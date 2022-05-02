package jdbc;

import contracts.Contract;
import contracts.InternetConnectionContract;
import contracts.MobileConnectionContract;
import contracts.TelevisionContract;
import entities.Human;

import java.sql.*;
import java.time.LocalDate;
import java.util.Objects;

public class H2Utils {

    public static boolean createTables() {
        try {
            Connection con = H2Connector.connect();
            Statement createStatement = con.createStatement();
            createStatement.executeUpdate(H2Queries.createRepoTable());
            createStatement.executeUpdate(H2Queries.createCustomersTable());
            return true;
        } catch (SQLException e) {
            System.err.println("Exception occurred while creating tables");
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            System.err.println("Exception occurred while setting connection");
            return false;
        }
    }

    public static void printRepoTable() {
        try {
            Connection con = H2Connector.connect();
            PreparedStatement printRepoTable = con.prepareStatement(H2Queries.getRepo());
            ResultSet resultSet = printRepoTable.executeQuery();

            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                LocalDate startDate = resultSet.getDate(2).toLocalDate();
                LocalDate expDate = resultSet.getDate(3).toLocalDate();
                int number = resultSet.getInt(4);
                int ownerId = resultSet.getInt(5);
                String type = resultSet.getString(6);
                String properties = resultSet.getString(7);
                System.out.println("ID: " + id + "\tStart date: " + startDate + "\tExpiration date: " + expDate + "\tNumber: " + number + "\tOwnerID: " + ownerId + "\tType: " + type + "\tProperties: " + properties);
            }
        } catch (SQLException e) {
            System.err.println("Exception occurred while printing repo table");
            return;
        } catch (ClassNotFoundException e) {
            System.err.println("Exception occurred while setting connection");
            return;
        }
    }

    public static Human getCustomerById(int ID, Connection con) throws SQLException {
        PreparedStatement getCustomerById = con.prepareStatement(H2Queries.getCustomerById());
        getCustomerById.setInt(1, ID);
        try {
            ResultSet resultSet = getCustomerById.executeQuery();
            if (!resultSet.next()) {
                return null;
            }
            Human person = new Human(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getDate("date_of_birth").toString(), resultSet.getString("gender"), resultSet.getString("passport"));
            resultSet.close();
            getCustomerById.close();
            return person;
        } catch (SQLException e) {
            System.err.println("Exception occurred while getting person with id = " + ID);
            return null;
        }
    }

    public static Contract getContractById(int ID, Connection con) throws SQLException {
        PreparedStatement getContractById = con.prepareStatement(H2Queries.getContractById());
        getContractById.setInt(1, ID);
        try {
            ResultSet resultSet = getContractById.executeQuery();
            if (!resultSet.next()) {
                return null;
            }
            String startDate = resultSet.getDate("start_date").toString();
            String expDate = resultSet.getDate("exp_date").toString();
            int number = resultSet.getInt("number");
            int ownerID = resultSet.getInt("owner_id");
            String type = resultSet.getString("type");
            String[] properties = resultSet.getString("properties").split(";");
            Human customer = getCustomerById(ownerID, con);
            if (customer == null) {
                System.err.println("Customer with id = " + ownerID + " wasn't found");
                return null;
            }
            resultSet.close();
            getContractById.close();
            if (Objects.equals(type, "Television")) {
                return new TelevisionContract(ID, startDate, expDate, number, customer, properties[0]);
            } else if (Objects.equals(type, "MobileConnection")) {
                return new MobileConnectionContract(ID, startDate, expDate, number, customer, Integer.parseInt(properties[0]), Integer.parseInt(properties[1]), Integer.parseInt(properties[2]));
            } else {
                return new InternetConnectionContract(ID, startDate, expDate, number, customer, Integer.parseInt(properties[0]));
            }
        } catch (SQLException e) {
            System.err.println("Exception occurred while getting contract with id = " + ID);
            return null;
        }
    }

    public static boolean addCustomer(Human customer, Connection con) throws SQLException {
        PreparedStatement addCustomer = con.prepareStatement(H2Queries.addCustomer());
        addCustomer.setInt(1, customer.getID());
        addCustomer.setString(2, customer.getFIO());
        addCustomer.setString(3, customer.getBirthday().toString());
        addCustomer.setString(4, customer.getGender());
        addCustomer.setString(5, customer.getPassport());
        try {
            addCustomer.executeUpdate();
            addCustomer.close();
            return true;
        } catch (SQLException e) {
            System.err.println("Exception occurred while adding customer with id = " + customer.getID());
            return false;
        }
    }

    public static boolean addContract(Contract contract) {
        try {
            Connection con = H2Connector.connect();
            if (getContractById(contract.getID(), con) != null) {
                System.err.println("Contract with id = " + contract.getID() + " is already exists");
                return false;
            }
            if (getCustomerById(contract.getOwner().getID(), con) == null) {
                boolean result = addCustomer(contract.getOwner(), con);
                if (!result) {
                    return false;
                }
            }
            PreparedStatement addContract = con.prepareStatement(H2Queries.addContract());
            addContract.setInt(1, contract.getID());
            addContract.setString(2, contract.getStartDate().toString());
            addContract.setString(3, contract.getExpirationDate().toString());
            addContract.setInt(4, contract.getNumber());
            addContract.setInt(5, contract.getOwner().getID());
            addContract.setString(6, contract.getClass() == TelevisionContract.class ? "Television" : contract.getClass() == MobileConnectionContract.class ? "MobileConnection" : "InternetConnection");
            addContract.setString(7, contract.getClass() == TelevisionContract.class ? ((TelevisionContract) contract).getChannelsPackage() : contract.getClass() == MobileConnectionContract.class ? ((MobileConnectionContract) contract).getMinutes() + ";" + ((MobileConnectionContract) contract).getSms() + ";" + ((MobileConnectionContract) contract).getTraffic() + ";" : String.valueOf(((InternetConnectionContract) contract).getSpeed()));
            addContract.executeUpdate();
            addContract.close();
            con.close();
            return true;
        } catch (SQLException e) {
            System.err.println("Exception occurred while adding contract with id = " + contract.getID());
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            System.err.println("Exception occurred while setting connection");
            return false;
        }
    }

}

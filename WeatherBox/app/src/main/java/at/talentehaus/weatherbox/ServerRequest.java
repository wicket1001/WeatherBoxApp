package at.talentehaus.weatherbox;

import org.json.*;

public class ServerRequest {
    // The first thing upon user login
    public static String queryLoggedInUserAndCustomerList() {
        String suffix = "/1/me";
        return new Requests().get(suffix, null);
    }

    // Manage a customer
    public static String queryTheUsersCustomerList() {
        String suffix = "/1/customers";
        return new Requests().get(suffix, null);
    }

    public static String addNewCustomer() {
        String suffix = "/1/customers";
        try {
            String json = new JSONObject("{" +
                    "        'name': 'enter name'," +
                    "        'street': 'enter street'," +
                    "        'city': 'enter city'," +
                    "        'note': 'enter note'" +
                    "    }").toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  new Requests().get(suffix, null);
    }

    public static String sendEmailOnBehalfThisCustomer() {
        String suffix = "/1/customer/" + Credentials.cid + "/cn-sending/";
        String json = null;
        try {
            json = new JSONObject("{'receivers': [" +
                    "        'person1@test.com'," +
                    "        'person2@test.com'" +
                    "    ]," +
                    "        'subject': 'Hi all - from rapidM2M!'," +
                    "        'body': '<html><h1>Hi all</h1>My first message sent via rapidM2M BACKEND API</html>'" +
                    "    }").toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new Requests().post(suffix, json);
    }

    public static String deleteCustomerAllHisSitesAndData() {
        String suffix = "/1/customer";
        return new Requests().get(suffix, null);
    }

    public static String sendSMSBehalfThisCostumer() {
        String suffix = "/1/costumer" + Credentials.cid + "/cn-sendsms/";
        String json = null;
        try {
            json = new JSONObject("{'receivers': [" +
                    "        '+4311111111'," +
                    "        '+4312222222'" +
                    "    ]," +
                    "        'subject': 'Hi all - from rapidM2M!'" +
                    "    }").toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new Requests().post(suffix, json);
    }

    //Manage a site
    public static String queryCustomersListOfSites() {
        String suffix = "/1/customers/" + Credentials.cid + "/sites";
        return new Requests().get(suffix, null);
    }

    public static String querySitesBlueprint() {
        String suffix = "/1/customers/" +Credentials.cid + "/sites/" + Credentials.sid + "/blueprint";
        return new Requests().get(suffix, null);
    }

    //Manage a device

    //Sites status&configuration data
    public static String querySitesConfiguration() {
        String suffix = "/1/customers/" + Credentials.cid + "/sites/" + Credentials.sid + "/config0";
        return new Requests().get(suffix, null);
    }

    public static String modifySitesConfiguration() {
        String suffix = "/1/customers/" + Credentials.cid + "/sites/" + Credentials.sid + "/config0";
        String json = null;
        try {
            json = new JSONObject("{" +
                    "        'TransmissionInterval': 5," +
                    "        'stamp': '20180217124628782'" +
                    "    }").toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new Requests().put(suffix, json);
    }

    // Sites Time Series Data
    public static String queryYoungestRawValues() {
        String suffix = "/1/customers/" + Credentials.cid + "/sites/" + Credentials.sid + "/histdata0/youngest";
        String json = null;
        try {
            json = new JSONObject("{" +
                    "        'select': [" +
                    "            'Temperature'," +
                    "            'VoltageBattery'," +
                    "            'VoltageUSB'" +
                    "        ]" +
                    "    }").toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new Requests().get(suffix, json);
    }

    public static String queryTimeWindowWithRawValues() {
        String suffix = "/1/customers/" + Credentials.cid + "/sites/" + Credentials.sid + "/histdata0";
        String json = null;
        try {
            json = new JSONObject("{ 'select': [" +
                    "        'ch0'," +
                    "        'ch3'," +
                    "        'ch1'" +
                    "    ]," +
                    "        'from': '20150101'," +
                    "        'until': '*'" +
                    "    }").toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new Requests().get(suffix, json);
    }

    public static String insertNewValuesHistoricalDataChannel() {
        String suffix = "/1/customers/" + Credentials.cid + "/sites/" + Credentials.sid + "/histdata0";
        String json = null;
        try {
            json = new JSONObject("{" +
                    "        'Temperature': 12," +
                    "        'VoltageBattery': 4.5," +
                    "        'VoltageUSB': 1.2" +
                    "    }").toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new Requests().post(suffix, json);
    }

    // Sites position data
    public static String queryYoungestPositionValues() {
        String suffix = "/1/customers/" + Credentials.cid + "/sites/" + Credentials.sid + "/pos/youngest";
        return new Requests().get(suffix, null);
    }

    // Manage users
    public static String queryUserList() {
        String suffix = "/1/users";
        return new Requests().get(suffix, null);
    }

    public static String queryCustomersUserList() {
        String suffix = "/1/customers/" + Credentials.cid + "/users/";
        return new Requests().get(suffix, null);
    }

    public static String queryUsersProfile() {
        String suffix = "/1/customers/" + Credentials.cid + "/users/";
        return new Requests().get(suffix, null);
    }
}

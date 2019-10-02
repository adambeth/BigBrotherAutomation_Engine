package testUtilities.EndPoints;

public interface testEndpoints {

    String FINANCIAL_TERMS_CALCULATOR = "/financial-terms/calculator";

    //Clients Endpoints

    String ADD_NEW_CLIENT = "/new";

    String ADD_CHANNEL = "/channel/add";

    String ADD_NEW_WHATSAPP_INTEGRATION = "/client/whatsapp/integration/new";
    String USSD = "http://docker-minion01.dev.za01.payd.co:31905/truteq/ussd";
    String ADD_NEW_CLIENT_CHANEL = "http://control-ui-backend.qa.za01.payd.co/client/new";



}

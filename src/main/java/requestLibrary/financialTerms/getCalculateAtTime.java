package requestLibrary.financialTerms;

public class getCalculateAtTime {

    public String getRequest(String clientID, String productID, String purchaseAmount, String dateAndTime){

        String requestUrl = "http://docker-minion04.dev.za01.payd.co:30309/financial-terms/calculateAtTime?+clientId="+
                clientID + "&productId="+
                productID +"&purchaseAmount=" +
                purchaseAmount +"&dateAndTime="+
                dateAndTime;
        return requestUrl;

    }

}

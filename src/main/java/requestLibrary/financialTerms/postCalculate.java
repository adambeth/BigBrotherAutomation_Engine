package requestLibrary.financialTerms;


public class postCalculate
{
    private String purchaseValue;

    private String feeConfigTime;

    private String clientId;

    private String productId;

    private String vendorId;

    public postCalculate(String purchaseValue, String feeConfigTime, String clientId, String productId, String vendorId) {
        this.purchaseValue = purchaseValue;
        this.feeConfigTime = feeConfigTime;
        this.clientId = clientId;
        this.productId = productId;
        this.vendorId = vendorId;
    }

    public String getPurchaseValue ()
    {
        return purchaseValue;
    }

    public void setPurchaseValue (String purchaseValue)
    {
        this.purchaseValue = purchaseValue;
    }

    public String getFeeConfigTime ()
    {
        return feeConfigTime;
    }

    public void setFeeConfigTime (String feeConfigTime)
    {
        this.feeConfigTime = feeConfigTime;
    }

    public String getClientId ()
    {
        return clientId;
    }

    public void setClientId (String clientId)
    {
        this.clientId = clientId;
    }

    public String getProductId ()
    {
        return productId;
    }

    public void setProductId (String productId)
    {
        this.productId = productId;
    }

    public String getVendorId ()
    {
        return vendorId;
    }

    public void setVendorId (String vendorId)
    {
        this.vendorId = vendorId;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [purchaseValue = "+purchaseValue+", feeConfigTime = "+feeConfigTime+", clientId = "+clientId+", productId = "+productId+", vendorId = "+vendorId+"]";
    }
}
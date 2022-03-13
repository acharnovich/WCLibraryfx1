package Model;


public class PhoneNumber
{
    private int countryCode;
    private int areaCode;
    private int threeLocal;
    private int lastFour;

    public PhoneNumber()
    {
        this.countryCode = 0;
        this.areaCode = 000;
        this.threeLocal = 000;
        this.lastFour = 0000;

    }

    public PhoneNumber(int countryCode, int areaCode, int threeLocal, int lastFour)
    {
        this.countryCode = countryCode;
        this.areaCode = areaCode;
        this.threeLocal = threeLocal;
        this.lastFour = lastFour;
    }

    public int getCountryCode()
    {
        return countryCode;
    }

    public void setCountryCode(int countryCode)
    {
        this.countryCode = countryCode;
    }

    public int getAreaCode()
    {
        return areaCode;
    }

    public void setAreaCode(int areaCode)
    {
        this.areaCode = areaCode;
    }

    public int getThreeLocal()
    {
        return threeLocal;
    }

    public void setLocalNum(int threeLocal)
    {
        this.threeLocal = threeLocal;
    }

    public int getLastFour()
    {
        return lastFour;
    }

    public void setLastFour(int lastFour)
    {
        this.lastFour = lastFour;
    }

    @Override
    public String toString()
    {

        return "Phone Number: " +
                "+" + countryCode + "-"+ areaCode +
                "-" + threeLocal + "-" + lastFour;
    }
    public boolean checkPhoneNum(int countryCode, int areaCode, int threeLocal, int lastFour){

        if (String.valueOf(countryCode).length()  + String.valueOf(areaCode).length() + String.valueOf(threeLocal).length() + String.valueOf(lastFour).length() > 11)
        {
            System.out.println("Too many numbers");
            return true;
        }
        return false;
    }
}


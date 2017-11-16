package pojo;

import java.util.Date;

public class hotelDealDetails {

    String hotelName;
    int nightlyRate;
    String promoText;
    int dealValue;
    int dealType;
    Date startDate;
    Date endDate;


    public hotelDealDetails(String hotelName, int nightlyRate, String promoText, int dealValue, int dealType, Date startDate, Date endDate) {
        this.hotelName = hotelName;
        this.nightlyRate = nightlyRate;
        this.promoText = promoText;
        this.dealValue = dealValue;
        this.dealType = dealType;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getNightlyRate() {
        return nightlyRate;
    }

    public void setNightlyRate(int nightlyRate) {
        this.nightlyRate = nightlyRate;
    }

    public String getPromoText() {
        return promoText;
    }

    public void setPromoText(String promoText) {
        this.promoText = promoText;
    }

    public int getDealValue() {
        return dealValue;
    }

    public void setDealValue(int dealValue) {
        this.dealValue = dealValue;
    }

    public int getDealType() {
        return dealType;
    }

    public void setDealType(int dealType) {
        this.dealType = dealType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        hotelDealDetails that = (hotelDealDetails) o;

        if (nightlyRate != that.nightlyRate) return false;
        if (dealValue != that.dealValue) return false;
        if (dealType != that.dealType) return false;
        if (hotelName != null ? !hotelName.equals(that.hotelName) : that.hotelName != null) return false;
        if (promoText != null ? !promoText.equals(that.promoText) : that.promoText != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        return endDate != null ? endDate.equals(that.endDate) : that.endDate == null;
    }

    @Override
    public int hashCode() {
        int result = hotelName != null ? hotelName.hashCode() : 0;
        result = 31 * result + nightlyRate;
        result = 31 * result + (promoText != null ? promoText.hashCode() : 0);
        result = 31 * result + dealValue;
        result = 31 * result + dealType;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }
}

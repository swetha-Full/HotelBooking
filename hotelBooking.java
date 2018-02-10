package hotel;

import java.io.*;
import java.util.Arrays;


public class hotelBooking {
	String name;
	int ratings;
	double costPerDay;
	int discountPercentage;
	int discountDays;
	
	

	public hotelBooking(String hotelName, int rating, double cost, int offer,int validOffer)throws IOException {
		this.name = hotelName;
		this.ratings = rating;
		this.costPerDay= cost;
		this.discountPercentage=offer;
		this.discountDays=validOffer;
	}
	public hotelBooking(String hotelName, double cost, int offer,int validOffer)throws IOException {
		this.name = hotelName;
		this.costPerDay= cost;
		this.discountPercentage=offer;
		this.discountDays=validOffer;
	}
	public static double computeOffer(double discounts,double cost,int days)
	{
		double offer=(discounts/100)*cost;
		double bill=cost*days-offer;
		return bill;
	}
	public static boolean foundAHotel(double bill,double money)
	{
		if(money>=bill)
			return true;
		
		else return false;
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	double amountPayableByUser=0;
	 int countOfHotels=0;
	 boolean result=false;
	double offer;
	int j=0;
	String bookedHotelName="";
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of hotels:");
		int numberOfHotels = Integer.parseInt(br.readLine());
		hotelBooking hotels[] = new hotelBooking[numberOfHotels];
		double[] cost=new double[numberOfHotels];
		for (int i = 0; i < numberOfHotels; i++) 
		{
			System.out.println("Enter the hotel name:");
			String name= br.readLine();
			System.out.println("Enter the hotel rating:");
			int rating = Integer.parseInt(br.readLine());
			System.out.println("Enter the hotel cost per day:");
			double price= Double.parseDouble(br.readLine());
			System.out.println("Enter the discount % provided by the hotel: ");
			int discounts=Integer.parseInt(br.readLine());
			System.out.println("Enter the Number of days after which discount  % can be applied: ");
			int discountsDays=Integer.parseInt(br.readLine());
		hotels[i]=new hotelBooking(name,rating,price,discounts,discountsDays);
		}
		System.out.println("Enter the user money:");
		double userMoney = Double.parseDouble(br.readLine());
		System.out.println("Enter the rating of hotel the user is looking for: ");
		int userRating = Integer.parseInt(br.readLine());
		System.out.println("Enter the number of the days the user wants the room for: ");
		int days = Integer.parseInt(br.readLine());
		for (int k = 0; k < numberOfHotels; k++) 
		{
			
      if(userRating==hotels[k].ratings)
      {cost[k]=hotels[k].costPerDay;
    	  for(double c:cost)
    	  {
    		 
    		  if(days>=hotels[k].discountDays)
    	    	 {
    			  bookedHotelName=hotels[k].name;
    	    		amountPayableByUser=computeOffer(hotels[k].discountPercentage,hotels[k].costPerDay,days); 
    	    	 }
    	    	 else
    	    	 {
    	    		 bookedHotelName=hotels[k].name;
    	    		 amountPayableByUser=days*hotels[k].costPerDay;
    	    	 }
    	 
    	  }
    	  
    	
      result=foundAHotel(amountPayableByUser,userMoney);
      }
		}
      
	if(result==true)
			
			System.out.println("Hotel Booked for "+days +"days in "+userRating+ "star hotel "+ bookedHotelName+" for the cost of "+amountPayableByUser);
		
		else
			System.out.println("Sorry! you dont have sufficient amount to book any hotel");
		




}
}
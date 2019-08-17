package ShoppingCart;
import java.util.*;
public class Cart extends Item
{
	static Item ObjectOfItemClass=new Item();
	static Cart ObjectOfCartClass=new Cart();
	static int NoOfTotalItems=ObjectOfItemClass.item_name.length;
	
	static int CartQuantity[]=new int[NoOfTotalItems];
	
	
	static Scanner in=new Scanner(System.in);
	static int ExitCart=0;
	public void Cart()//Constructor
	{
		for(int i=0;i<NoOfTotalItems;i++)
		{
			CartQuantity[i]=0;
			
		}
	}
	public static void main(String args[])
	{
		System.out.println("Welcome To Shopping Cart");
		System.out.println("List of Available Items is");
		ObjectOfItemClass.DisplayItem();
		while(ExitCart!=1)
		{
			System.out.println();
			System.out.println("Input 1 for ADDING AN ITEM TO CART");
			System.out.println("Input 2 to UPDATE ITEM QUANTITY");
			System.out.println("Input 3 to VIEW CART");
			System.out.println("Input 4 for FINAL BILL");
			System.out.println("Input 5 or any other number to leave Shopping Cart");
			
			int userInput=in.nextInt();
			
			if(userInput==1)
				ObjectOfCartClass.AddItemToCart();
			else if(userInput==2)
					ObjectOfCartClass.UpdateCart();
				else if(userInput==3)
						ObjectOfCartClass.ShowCart();
					else if(userInput==4)
							ObjectOfCartClass.GenerateBill();
					else
						{
						System.out.println("-------------------------------");
							System.out.println("Your Input was "+userInput);
							ExitCart = 1;
							System.out.println("Thank You For Shopping");
							System.out.println("Have a Nice Day ahead");
							System.out.println("-------------------------------");
						}
		}
	}
	public static void AddItemToCart()
	{
		ObjectOfItemClass.DisplayItem();
		System.out.println(" ");
		System.out.println("Enter S.No. of Item you wish to add to Cart");
		int temporary=in.nextInt();
		if((temporary>=1)&&(temporary<=NoOfTotalItems))
			{
				CartQuantity[(temporary-1)]++;
				System.out.println();
				System.out.println("-------------------------------");
				System.out.println("Item Successfully Added To Cart");
				System.out.println("-------------------------------");
			}
		else
		
			System.out.println("Item not in List");
		
			
	}	
	public static void DisplayCart()
	{
		System.out.println("S.No.\tItem Name\tItem Price\tQuantity");
		int a=0;
		for(int i=0;i<NoOfTotalItems;i++)
		{
			if(CartQuantity[i]>0)
				System.out.println((++a)+"\t"+ObjectOfItemClass.item_name[i]+"\t\t"+ObjectOfItemClass.item_price[i]+"\t\t"+ObjectOfCartClass.CartQuantity[i]);
		}
		
	}
	public static void UpdateCart()
	{
		int totalitemsincart=0;
		for(int i=0;i<NoOfTotalItems;i++)
		  if(CartQuantity[i]>0)
			   totalitemsincart++;
		if(totalitemsincart==0)
		{
			System.out.println("--------------------------------------------");
			System.out.println("Unable to Update Cart because Cart is Empty");
			System.out.println("--------------------------------------------");
		}
		else
		{
			ObjectOfCartClass.DisplayCart();
			System.out.println("Enter S.No. of item of which you wish to update the quantity");
			int InputSerialNumber=in.nextInt();
			if(InputSerialNumber<=totalitemsincart)
			{
				InputSerialNumber--;
				System.out.println("Enter 1 for increase in quantity");
				System.out.println("Enter 2 for decrease in quantity");
				int ProcessToBeDone=in.nextInt();
				int i=0;
				if(ProcessToBeDone == 1)
				{
					for(int p=0;p<NoOfTotalItems;p++)
					{
						if(CartQuantity[i]>0)
						{
							if(InputSerialNumber==0)
							{
								CartQuantity[i]++;
								System.out.println("-------------------------------");
								System.out.println("Quantity Increased Successfully");
								System.out.println("-------------------------------");
								ObjectOfCartClass.DisplayCart();
								break;
							}
							else
								InputSerialNumber--;
						}
						else i++;
					}
				}
				i=0;
				if(ProcessToBeDone == 2)
				{
					for(int p=0;p<NoOfTotalItems;p++)
					{
						if(CartQuantity[i]>0)
						{
							if(InputSerialNumber==0)
							{
								CartQuantity[i]--;
								System.out.println("-------------------------------");
								System.out.println("Quantity Decreased Successfully");
								System.out.println("-------------------------------");
								ObjectOfCartClass.DisplayCart();
								break;
							}
							else
								InputSerialNumber--;
						}
						else i++;
					}
				}
			}
			else
			{
				System.out.println("-------------------------------");
				System.out.println("         Wrong Choice");
				System.out.println("-------------------------------");
			}
		}
    }//UpdateCart
	public void ShowCart()
	{
		int totalitemsincart=0;
		for(int i=0;i<NoOfTotalItems;i++)
		   if(CartQuantity[i]>0)
			   totalitemsincart++;
		  
		if(totalitemsincart==0)
			System.out.println("Cart Empty");
		else
			ObjectOfCartClass.DisplayCart();
		
	}
	public void GenerateBill()
	{
		int amount=0;
		for(int p=0;p<NoOfTotalItems;p++)
			if(CartQuantity[p]>0)
				amount+=ObjectOfItemClass.item_price[p]*CartQuantity[p];
		ObjectOfCartClass.ShowCart();
		System.out.println("------------------------------------");
		System.out.println("Total Payable Amount = " +amount);
		System.out.println("------------------------------------");
	}
}

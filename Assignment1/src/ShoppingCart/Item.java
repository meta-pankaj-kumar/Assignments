package ShoppingCart;

public class Item 
{
		static String item_name[]={"Ball","Grocery","Coffee","Shoes","Radio"};
		static int item_price[]={10,20,30,40,50};
		public static void DisplayItem() 
		{
			System.out.println("S.No.\tItem Name\tItem Price");
			for(int i=0;i<5;i++)
			{
				System.out.println((i+1)+"\t"+item_name[i]+"\t \t"+item_price[i]);
			}
		}
}
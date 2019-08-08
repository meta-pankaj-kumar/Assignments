package Problem1;
import java.util.Scanner;
public class mainRunner {
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		Dictionary dictionary=new Dictionary();
		//runs until user terminates
		while(true){
			try{
				System.out.println("Enter 1 for Adding word to Dictionary");
				System.out.println("Enter 2 for Deleting element of Dictionary");
				System.out.println("Enter 3 for Getting Meaning of a Word");
				System.out.println("Enter 4 for get sorted Word Value Pairs");
				System.out.println("Enter 5 for get sorted Word Value Pairs between two Words");
				int choice=in.nextInt();
				in.nextLine();
				switch(choice){
					case 1:{
						System.out.println("Enter a word");
						String word=in.nextLine();
						System.out.println("Enter its meaning");
						String meaning=in.nextLine();
						dictionary.add(word, meaning);
						System.out.println("word added to dictionary");
						break;
					}
					case 2:{
						System.out.println("Enter a word to be deleted");
						String word=in.nextLine();
						dictionary.delete(word);
						System.out.println("Word "+word+" Successfully Deleted from Dictionary");
						break;
					}
					case 3:{
						System.out.println("Enter a word");
						String word=in.nextLine();
						System.out.println("Meaning of "+word+" is "+dictionary.get(word));
						break;
					}
					case 4:
					{
						String array[][]=dictionary.getSortedKeyValuePairs();
						for(int indexFirst=0;indexFirst<array.length;indexFirst++){
							for(int indexSecond=0;indexSecond<2;indexSecond++){
								System.out.print(array[indexFirst][indexSecond]+" \t\t ");
							}
							System.out.println();
						}
						break;
					}
					case 5:
					{
						System.out.println("Enter First Word");
						String firstWord=in.nextLine();
						System.out.println("Enter Second Word");
						String secondWord=in.nextLine();
						String array[][]=dictionary.getSortedKeyValuePairs(firstWord, secondWord);
						for(int indexFirst=0;indexFirst<array.length;indexFirst++){
							for(int indexSecond=0;indexSecond<2;indexSecond++){
								System.out.print(array[indexFirst][indexSecond]+" \t\t ");
							}
							System.out.println();
						}
						break;
					}
					default:
						throw new Exception("Invalid Input");
				}
			}
			//printing exception
			catch(Exception e){
				System.out.println(e);
			}
		}
	}
}
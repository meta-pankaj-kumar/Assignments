/*
 * Polynomial Class for calculating Degree
 * Methods
 * 		Polynomial - Parameterised Constructor
 * 		midList - Contains linked list at level 2
 * 		degree - returns degree of polynomial
 * 		extract - extracts up the words
 */
package Polynomial;
import java.util.LinkedList;
import java.util.List;
public class Polynomial {
	private String poly;
	private List<List> mainList=new LinkedList<List>();
	/*
	 * @param String type Polynomial Expression
	 * @return null
	 */
	public Polynomial(String poly){
		if(poly.charAt(0)!='-' || poly.charAt(0)!='+'){
			poly="+"+poly;
		}
		this.poly=poly;
	}
	/*
	 * @param String type value of single unit of Polynomial
	 * @return null
	 */
	private void midList(String smallPoly){
		LinkedList<String> midList=new LinkedList<String>();
		int indexFirst,indexSecond=0;
		for(indexFirst=0;indexFirst<smallPoly.length();indexFirst++){
			for(indexSecond=indexFirst+1;indexSecond<smallPoly.length();indexSecond++){
				char ch=smallPoly.charAt(indexSecond);
				if(!(ch>='0' && ch<='9')){
					break;
				}
			}
			midList.add(smallPoly.substring(indexFirst,indexSecond));
			break;
		}
		for(int indexThird=indexSecond;indexThird<smallPoly.length();indexThird++){
			String po="";
			for(indexFirst=indexThird+1;indexFirst<smallPoly.length();indexFirst++){
				char ch=smallPoly.charAt(indexFirst);
				if(!(ch>='0' && ch<='9')){
					if(po==""){
						po="1";
						break;
					}
					break;
				}
				else{
					po+=smallPoly.charAt(indexFirst);
				}
			}
			String variableWithPower=String.valueOf(smallPoly.charAt(indexThird));
			if(po==""){
				po="1";
			}
			variableWithPower+=po;
			indexThird=--indexFirst;
			midList.add(variableWithPower);
		}
		mainList.add(midList);
	}
	/*
	 * @param null
	 * @return int type degree
	 */
	public int degree(){
		extract();
		int maxDegree=0;
		for(int indexFirst=0;indexFirst<mainList.size();indexFirst++){
			int degree=0;
			for(int indexSecond=1;indexSecond<mainList.get(indexFirst).size();indexSecond++){
				degree+=Integer.parseInt(((String)(mainList.get(indexFirst).get(indexSecond))).substring(1));
			}
			maxDegree=Math.max(maxDegree, degree);
		}
		return maxDegree;
	}
	/*
	 * @param null
	 * @return null
	 */
	private void extract(){
		String smallPoly="";
		for(int indexFirst=0;indexFirst<poly.length();indexFirst++){
			char ch=poly.charAt(indexFirst);
			if(ch=='+'){
				for(int indexSecond=indexFirst+1;indexSecond<poly.length();indexSecond++){
					if(poly.charAt(indexSecond)!='+' && poly.charAt(indexSecond)!='-' ){
						smallPoly+=poly.charAt(indexSecond);
					}
					else {
						break;
					}
				}
				midList(smallPoly);
				smallPoly="";
			}
			else if(ch=='-'){
				for(int indexSecond=indexFirst+1;indexSecond<poly.length();indexSecond++){
					if(poly.charAt(indexSecond)!='+' &&  poly.charAt(indexSecond)!='-' ){
						smallPoly+=poly.charAt(indexSecond);
					}
					else {
						break;
					}
				}
				midList(smallPoly);
				smallPoly="";
			}
		}
	}
}
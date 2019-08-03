/**
 * Class for Calculating Mass of Compunds containing C , H and O
 * Methods - 
 * 		calculateMass - returns the mass of Compound
 * 		elementCombiner - adds element to List with there coefficients
 * 		getElementWithItsCoefficient - returns element with its Coefficient
 * 		getNumericCoefficient - returns Numeric Coefficient of Element
 * 		getIndexOFClosingBracket - returns index of closing bracket
 */
package Problem3;
import java.util.ArrayList;
public class MassCalculator {
	private String[] formulaArray;
	private ArrayList<String> formulaList;
	private int MASS_OF_CARBON=12;
	private int MASS_OF_HYDROGEN=1;
	private int MASS_OF_OXYGEN=16;
	/**
	 * @param null
	 * @return total mass of compound
	 * @throws Exception for unclosed Paranthesis
	 */
	public int calculateMass(String formula) throws Exception {
		this.formulaArray=formula.split("");
		this.formulaList=new ArrayList<String>();
		elementCombiner();
		int massOfFormula=0;
		for(int indexFirst=0;indexFirst<this.formulaList.size();indexFirst++){
			String element=this.formulaList.get(indexFirst);
			if(element.charAt(0)=='C'){
				 massOfFormula+=Integer.parseInt(element.substring(1))*MASS_OF_CARBON;
			}
			if(element.charAt(0)=='H'){
				 massOfFormula+=Integer.parseInt(element.substring(1))*MASS_OF_HYDROGEN;
			}
			if(element.charAt(0)=='O'){
				 massOfFormula+=Integer.parseInt(element.substring(1))*MASS_OF_OXYGEN;
			}			
		}
		return massOfFormula;
	}
	/**
	 * @param null
	 * @return null
	 * @throws Exception for unclosed Paranthesis
	 */
	private void elementCombiner() throws Exception{
		for(int indexFirst=1;indexFirst<this.formulaArray.length;indexFirst++) {
			if(this.formulaArray[indexFirst].equals("C") || this.formulaArray[indexFirst].equals("H") || this.formulaArray[indexFirst].equals("O")) {
				this.formulaList.add(getElementWithItsCoefficient(indexFirst));
			}
			else{
				if(this.formulaArray[indexFirst].equals("(")){
					int indexOfClosingBracket=getIndexOFClosingBracket(indexFirst);
					String coefficient=getNumericCoefficient(indexOfClosingBracket+1);
					indexFirst++;
					while(indexFirst!=indexOfClosingBracket){
						if(this.formulaArray[indexFirst].equals("C") || this.formulaArray[indexFirst].equals("H") || this.formulaArray[indexFirst].equals("O")) {
							String element=getElementWithItsCoefficient(indexFirst);
							this.formulaList.add(element.substring(0,1)+(Integer.toString((Integer.parseInt(element.substring(1)))*(Integer.parseInt(coefficient)))));
						}
						indexFirst++;
					}
				}	
			}
		}
	}
	/**
	 * @param int type Starting Index
	 * @return String type Element Followed by its Coefficient 
	 */
	private String getElementWithItsCoefficient(int indexFirst){
		String returnValue="";
		if(indexFirst+1 == this.formulaArray.length || (!(this.formulaArray[indexFirst+1].charAt(0)>='0' && this.formulaArray[indexFirst+1].charAt(0)<='9'))) {
			returnValue= (this.formulaArray[indexFirst]+"1");
		}
		else if((this.formulaArray[indexFirst+1].charAt(0)>='0' && this.formulaArray[indexFirst+1].charAt(0)<='9')){
			String element=this.formulaArray[indexFirst];
			indexFirst++;
			element+=getNumericCoefficient(indexFirst);
			returnValue=(element);
		}
		return returnValue;
	}
	/**
	 * @param int type starting index
	 * @return String type Numeric Coefficient
	 */
	private String getNumericCoefficient(int index){
		String coefficient="";
		while(index!=this.formulaArray.length){
			if(!(this.formulaArray[index].charAt(0)>='0' && this.formulaArray[index].charAt(0)<='9')){
				break;
			}
			else{
				coefficient+=this.formulaArray[index];
				index++;
			}
		}
		return coefficient;
	}
	/**
	 * @param indexFirst int type starting Index
	 * @return int type index of closing bracket
	 * @throws Exception if closing bracket is not found
	 */
	private int getIndexOFClosingBracket(int indexFirst) throws Exception{
		for(int index=indexFirst;index<this.formulaArray.length;index++){
			if(this.formulaArray[index].equals(")")){
				return index;
			}
		}
		throw new Exception(" ')' bracket Missing");
	}
}
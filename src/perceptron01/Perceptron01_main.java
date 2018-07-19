package perceptron01;

public class Perceptron01_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double input[][] = { {1,0,0}, {1,0,1}, {1,1,0}, {1,1,1}};
		double output[] = {-1, 1, 1, 1};
		
		//インスタンスの生成
		Perceptron01_lib plib = new Perceptron01_lib(input[0].length, 0.2, input, output);
		plib.getLearning();
		plib.getPredict(output);
			
	System.out.println("(0,0) = "+plib.getPredict(new double[] {1.0, 0.0, 0.0})); 
	System.out.println("(1,0) = "+plib.getPredict(new double[] {1.0, 1.0, 0.0})); 
	System.out.println("(0,1) = "+plib.getPredict(new double[] {1.0, 0.0, 1.0})); 
	System.out.println("(1,1) = "+plib.getPredict(new double[] {1.0, 1.0, 1.0})); 
	}

}

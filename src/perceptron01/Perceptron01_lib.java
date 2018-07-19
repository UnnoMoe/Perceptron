package perceptron01;

import java.util.Arrays;

public class Perceptron01_lib{
		private int n;//次元
		private double eta;//更新率
		private double input[][], output[], w[]; //input:データx, output:教師データ-1 or 1

		public Perceptron01_lib(int n, double eta, double[][] input, double[] output) {
			this.n = n;
			this.eta = eta;
			this.input = input;
			this.output = output;
			this.w = new double[n];
			for(int i = 0; i < n; i++)
				this.w[i] = 1; //wを１で初期化
		}

		public double getInnerProduct(double a[], double b[]) {
			double answer = 0;
			for(int i =0; i < a.length; i++) {
				answer += a[i]*b[i];				
			}
			return answer;
		}
		
		//学習関数
		public void getLearning() {
			for(int i = 0; i <input.length; i++) {
				double u = this.getInnerProduct(w, input[i]); //wx内積計算
				if(Math.signum(u) == output[i]) continue; //signum 正数１．０　負数―１．０　ゼロ０．０　を返す
				else {
					for(int j =0; j <w.length ; j++) {
						w[j] += this.eta*output[i]*input[i][j]; //最急降下法
					}
					i = -1; //更新があったのでグループの最初から（i++があるので-1にしておく）
				}
				System.out.println("w="+Arrays.toString(this.w));
			}
			
		}
		
		//課題
		public double getPredict(double data[]) {
			double answer = Math.signum(this.getInnerProduct(w, data)); //wx > 0 のとき、教師データ1の場合で1を返す、wx < 0 が教師データ-1の場合で-1を返す
			return answer;
		}
}


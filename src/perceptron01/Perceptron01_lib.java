package perceptron01;

import java.util.Arrays;

public class Perceptron01_lib{
		private int n;//����
		private double eta;//�X�V��
		private double input[][], output[], w[]; //input:�f�[�^x, output:���t�f�[�^-1 or 1

		public Perceptron01_lib(int n, double eta, double[][] input, double[] output) {
			this.n = n;
			this.eta = eta;
			this.input = input;
			this.output = output;
			this.w = new double[n];
			for(int i = 0; i < n; i++)
				this.w[i] = 1; //w���P�ŏ�����
		}

		public double getInnerProduct(double a[], double b[]) {
			double answer = 0;
			for(int i =0; i < a.length; i++) {
				answer += a[i]*b[i];				
			}
			return answer;
		}
		
		//�w�K�֐�
		public void getLearning() {
			for(int i = 0; i <input.length; i++) {
				double u = this.getInnerProduct(w, input[i]); //wx���όv�Z
				if(Math.signum(u) == output[i]) continue; //signum �����P�D�O�@�����\�P�D�O�@�[���O�D�O�@��Ԃ�
				else {
					for(int j =0; j <w.length ; j++) {
						w[j] += this.eta*output[i]*input[i][j]; //�ŋ}�~���@
					}
					i = -1; //�X�V���������̂ŃO���[�v�̍ŏ�����ii++������̂�-1�ɂ��Ă����j
				}
				System.out.println("w="+Arrays.toString(this.w));
			}
			
		}
		
		//�ۑ�
		public double getPredict(double data[]) {
			double answer = Math.signum(this.getInnerProduct(w, data)); //wx > 0 �̂Ƃ��A���t�f�[�^1�̏ꍇ��1��Ԃ��Awx < 0 �����t�f�[�^-1�̏ꍇ��-1��Ԃ�
			return answer;
		}
}


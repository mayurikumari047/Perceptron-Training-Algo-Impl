package com.nn;

import java.util.*;
import java.text.*;

class PerceptronTrainingAlgorithm
{
	static double TRAINING_PARAMETER = 10;    
	static int NUM_INSTANCES = 100;
	public static void main(String args[]){ 

		System.out.println("Training parameter set as "+TRAINING_PARAMETER);
		System.out.println("Number of instances: "+NUM_INSTANCES);
		double[] initialWeights = new double[3];
		int iteration =0;
		int output = 0, desiredOutput = 0;

		initialWeights[0] = randomNumber(-0.25,0.25);// w0
		initialWeights[1] = randomNumber(-1,1);// w1
		initialWeights[2] = randomNumber(-1,1);// w2
		
		System.out.println("Initial picked weights w0: "+initialWeights[0]+" w1:"+initialWeights[1]+" w2:"+initialWeights[2]);
		System.out.println("The line w0 + w1x1 + w2x2 = 0 is "+initialWeights[0]+" + "+initialWeights[1] +"*x + "+initialWeights[2]+"*y = 0");
		ArrayList dataSet = new ArrayList(); //collection of vectors S along with output from initial weights
		double[] class_s0 = new double [3]; 
		double[] class_s1 = new double [3];
		
		for(int j = 0; j < NUM_INSTANCES; j++){
			double x1 = randomNumber(-1 , 1);
			double x2 = randomNumber(-1 , 1);   

			output = calculateOutput(initialWeights, x1, x2);
			System.out.println("New Random Points: x1 = "+x1+",x2 = "+x2);
			if(output == 0){
				class_s0[0] = x1;
				class_s0[1] = x2;
				class_s0[2] = output;
				dataSet.add(class_s0);
				System.out.println("x1 = "+x1+",x2 = "+x2+" belongs to class S0");
			}else if(output == 1){
				class_s1[0] = x1;
				class_s1[1] = x2;
				class_s1[2] = output;
				dataSet.add(class_s1);
				System.out.println("x = "+x1+",y = "+x2+" belongs to class S1");
			}
		}

		double[] weights = new double[3];
		weights[0] = randomNumber(-1,1);// w0
		weights[1] = randomNumber(-1,1);// w1
		weights[2] = randomNumber(-1,1);// w2
		System.out.println("\nNew picked weights w0': "+weights[0]+" w1':"+weights[1]+" w2':"+weights[2]);

		double localError;
		int misclassification = 0;
		int misclassificationWithUpdatedWeights = 0;
		int epochNumber = 0;
		
		double s[] = new double[3];
		do {
			iteration++;
			Iterator iter = dataSet.iterator();
			
			//loop through all instances (complete one epoch)
			while(iter.hasNext()){

				s = (double[]) iter.next();
				output = calculateOutput(weights, s[0], s[1]);
				desiredOutput = (int) s[2];
				//System.out.println("\n PerceptronTrainingAlgorithm.main() output:"+output+" desiredOutput:"+desiredOutput);
				// difference between predicted and actual class values
				localError = desiredOutput - output;
				
				//update weights
				weights[0] += TRAINING_PARAMETER * localError;
				weights[1] += TRAINING_PARAMETER * localError * s[0];
				weights[2] += TRAINING_PARAMETER * localError * s[1];
				System.out.println("x1="+s[0]+" x2="+s[1]+" New set of updated weights  w0'': "+weights[0]+" w1'':"+weights[1]+" w2'':"+weights[2]);
				epochNumber++;
				
				if(desiredOutput != output){
					misclassification++;
				}
				
				/*int outputWithUpdatedWeights = calculateOutput(weights, s[0], s[1]);
				if(desiredOutput != outputWithUpdatedWeights){
					misclassificationWithUpdatedWeights++;
				}*/
				//System.out.println("\nNumber of misclassification = "+misclassificationWithUpdatedWeights+" with updated weights w0'':"+weights[0]+" w1'': "+weights[1] +" w2'':"+weights[2]);
			}
			
		} while (desiredOutput != output);
		System.out.println("Training parameter set as "+TRAINING_PARAMETER);
		System.out.println("Number of instances: "+NUM_INSTANCES);
		System.out.println("\nNumber of epochs:"+epochNumber);
		System.out.println("\nNumber of misclassification = "+misclassification+" with new weights w0':"+weights[0]+" w1': "+weights[1] +" w2':"+weights[2]);
		System.out.println("\n=======\nDecision boundary equation:");
		System.out.println("1*"+weights[0]+" + ("+weights[1] +"*x) + ("+weights[2]+"*y) = 0");
	} 

	/**
	 * returns a random double value within given range
	 * @param min value for required range
	 * @param max value of required range
	 * @return random double value between min and max
	 */ 
	public static double randomNumber(double e , double f) {
		DecimalFormat df = new DecimalFormat("#.####");
		double d = e + Math.random() * (f - e);
		String s = df.format(d);
		double x = Double.parseDouble(s);
		return x;
	}

	/**
	 * returns either 1 or 0 using the step activation function
	 * @param array of weights
	 * @param x1 input value
	 * @param x2 input value
	 * @return 1 or 0
	 */ 
	static int calculateOutput(double weights[], double x1, double x2)
	{
		double sum = 1 * weights[0] + x1 * weights[1] + x2 * weights[2];
		return (sum >= 0) ? 1 : 0;
	}

}

# Perceptron-Training-Algo-Impl
Implementation of Neural Networks - Perceptron Training Algorithm on input values picked randomly

Below are the steps done for this implementation:

(a)	Weights w0, w1, w2 picked uniformly at random.

(b)	Vectors x1, …. ,xn where n = 100 picked independently and uniformly at random on [−1, 1]2, call the collection of these vectors S.

(c)	S0 ⊂ S denote the collection of all x = [x1 x2] ∈ S satisfying [1 x1 x2][w0 w1, w2]T < 0.

(e)	Used Perceptron training algorithm to find the weights that can separate the two classes S0 and S1.

  i.	Used training parameter η = 1.
  
  ii.	Weights w0j , w1j , w2j picked independently and uniformly at random on [−1, 1].
  
  iii.Recorded the number of misclassifications when the weights [w0j , w1j , w2j ] were used.
  
  iv.	After one epoch of the perceptron training algorithm, new set of weights [w0jj, w1jj, w2jj] were recorded.
  
  v.	Recorded the number of misclassifications when the weights [w0jj, w1jj, w2jj] were used.
  
  vi.	Multiple epochs of the perceptron training algorithm were executed until convergence. 


# Perceptron-Training-Algo-Impl
Implementation of Neural Networks - Perceptron Training Algorithm on input values picked randomly

Below are the steps done for this implementation

(a)	Pick w0, w1, w2 uniformly at random.
(b)	Pick n = 100 vectors x1, …. ,xn independently and uniformly at random on [−1, 1]2, call the collection of these vectors S.
(c)	Let S0 ⊂ S denote the collection of all x = [x1 x2] ∈ S satisfying [1 x1 x2][w0 w1, w2]T < 0.
(e)	Use the perceptron training algorithm to find the weights that can separate the two classes S0 and S1. In detail,
  i.	Use the training parameter η = 1.
  ii.	Pick w0j , w1j , w2j  independently and uniformly at random on [−1, 1].  Write them in your report.
  iii.	Record the number of misclassifications if we use the weights [w0j , w1j , w2j ].
  iv.	After one epoch of the perceptron training algorithm, you will find a new set of weights [w0jj, w1jj, w2jj].
  v.	Record the number of misclassifications if we use the weights [w0jj, w1jj, w2jj].
  vi.	Do another epoch of the perceptron training algorithm, find a new set of weights, record the number of misclassifications, and so     on, until convergence. 


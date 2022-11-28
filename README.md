# cosc4353-project
By Ben, Brian, and Thien.

This project was made to convert the equations and functions of SymPy, a Python-based mathematical library, to Java
   while using the command line interface
   
*as this is a work in progress, and SymPy has hundreds of different functions and capabilities, we have some codes
   converted to java that function correctly, and many codes in the experimental folder to add in later*
   
Sympy functions converted to java:
1) Basic Operations - solve calculations ranging from trigonomic functions, to multiple exponential equations.
    Example: 
	
	*Enter your expression
	
	6^2+cos(45) ==> 6^2+cos(45) = 36.707106781186546
    
	
	6 ==> 6 = 6.0
    
	
	(6.7*10^-7)*(2.7*10^11) ==> (6.7*10^-7)*(2.7*10^11) = 180900.0
    
	
	(1/21)+(1/3) ==> (1/21)+(1/3) = 0.38095238095238093
    
	
	5 ==> 5 = 5.0*

2) Simplify - condense equations ranging from algebraic expressions, to multi-variable equations
    
	
	Example: 
	
	Enter the expression
	
	
	5x+7x ==> (12.0 * x) /n
    
	
	5y-2x ==> ((5.0 * y) - (2.0 * x))
    
	
	4y/4y ==> 1.0

3) Solve/Expand - expands an equation to fully algebraic expression, and/or solves algebraic equations
    
	
	Exmaple: Enter the expression
    
	
	Solve(x^2 == 49,x) ==> {{x->-7},{x->7}}
    
	
	Solve(sqrt(x-8)==3,x) ==> {{x->17}}
    
	
	Expand(1/(x+3)+1/(x+3)==10/(x^2-9),x) ==> 2/(3+x)==10/(-9+x^2)
    
	
	Expand((2x-4)(x-5)) ==> 20-14*x+2*x^2
    
	
	Expand((x^2+3y)^3) ==> x^6+9*x^4*y+27*x^2*y^2+27*y^3


4) Matrix - Creates a single or multiple matricies based off n rows and n columns, specified by the user, and
            then allows the user to either print the matrix, transpose the matrix, or multiply a matrix by another
            matrix added in the command line. 
   
   
   		Example: How many Matrices?
   
   
   		2
   
   
  		Matrix 1
   
   
   		Enter the number of rows and cols of the matrix (m*n)
   
   
   		3
   
   
   		3
   
   
   		Enter the elements of the matrix
   
   
   		1 2 3
   
   
  		4 5 6
   
   
   		7 8 9
   
   
   		Matrix 2
  
  
  		Enter the number of rows and cols of the matrix (m*n)
  
  
  		2
  
  
  		2
  
  
  		Enter the elements of the matrix
  
  
  		2 4
  
  
  		6 8
  
  
  		Which matrices you want to pick?
  
  
  		1
  
  
  		What operation do you want?
  
  
  		*
  
  
  		Pick the 2nd matrix
  
  
  		2
  
  
 		Not same dimension
  
  
  		Not same dimension
       

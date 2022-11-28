# cosc4353-project
## By Ben, Brian, and Thien.

This project was made to convert the equations and functions of SymPy, a Python-based mathematical library, to Java
   while using the command line interface
   
*as this is a work in progress, and SymPy has hundreds of different functions and capabilities, we have some codes converted to java that function correctly, and many codes in the experimental folder to add in later*
   
# Sympy functions converted to java:
## 1) Basic Operations - solve calculations ranging from trigonomic functions, to multiple exponential equations.
    Example: 
	
	Enter your expression
	6^2+cos(45)
	==> 6^2+cos(45) = 36.707106781186546
	(6.7*10^-7)*(2.7*10^11)
	==> (6.7*10^-7)*(2.7*10^11) = 180900.0
	(1/21)+(1/3)
	==> (1/21)+(1/3) = 0.38095238095238093

## 2) Simplify - condense equations ranging from algebraic expressions, to multi-variable equations
    
	
	Example: 
	
	Enter the expression
	5x+7x
	==> (12.0 * x)
	5y-2x
	==> ((5.0 * y) - (2.0 * x))
	4y/4y
	==> 1.0

## 3) Solve/Expand - expands an equation to fully algebraic expression, and/or solves algebraic equations
    
	
	Exmaple: Enter the expression
	Solve(x^2 == 49,x)
	==> {{x->-7},{x->7}}
	Solve(sqrt(x-8)==3,x)
	==> {{x->17}}
	Expand(1/(x+3)+1/(x+3)==10/(x^2-9),x)
	==> 2/(3+x)==10/(-9+x^2)
	Expand((2x-4)(x-5))
	==> 20-14*x+2*x^2
	Expand((x^2+3y)^3)
	==> x^6+9*x^4*y+27*x^2*y^2+27*y^3


## 4) Matrix - Creates a single or multiple matricies based off n rows and n columns, specified by the user, and then allows the user to either print the matrix, transpose the matrix, or multiply a matrix by another
            
		matrix command lines:
		p - print the matrix
		t - transpose the matrix
		m - multiply the matrix by another matrix
		exit - exit the program

			Example:

			Enter the number of rows and cols of the matrix (m*n)
			3 3
			Enter the elements of the matrix
			1 2 3
			4 5 6
			7 8 9
			What operation do you want?
			t
			1 4 7 
			2 5 8 
			3 6 9 
			What operation do you want?
			*
			Enter the 2nd matrix
			Enter the number of rows and cols of the matrix (m*n)
			3 3
			Enter the elements of the matrix
			7 6 8
			22 1 3
			1 7 9
			Result:
			102 59 83 
			132 73 103 
			162 87 123 


## 5) Sets
	sets command lines:
	add - add an element to the set
	remove - remove an element from the set
	union - find the union of two sets
	intersection - find the intersection of two sets
	difference - find the difference of two sets
	symmetricDifference - find the symmetric difference of two sets
	cartesianProduct - find the cartesian product of two sets
	showall - show all the sets
	changeSet - change the current set
	exit - exit the program

		Example:
		Enter the set name
		A
		Enter the set elements
		Enter your sets, type `!` when you're finished
		1 3 5 !
		[1, 3, 5]
		Enter the set name
		B
		Enter the set elements
		Enter your sets, type `!` when you're finished
		1 2 3 4 5 !
		[1, 2, 3, 4, 5]
		Enter the set name
		C
		Enter the set elements
		Enter your sets, type `!` when you're finished
		2 8 !
		[2, 8]
		Enter the set name
		done
		What set do you want?
		A
		A - What operation do you want?
		subset
		Enter the 2nd set name:
		B
		A is a subset of B? =>true
		A - What operation do you want?
		showall
		A
		[1, 3, 5]
		B
		[1, 2, 3, 4, 5]
		C
		[2, 8]
		A - What operation do you want?
		union
		Enter the 2nd set name:
		B
		The union of A and B is: [1, 2, 3, 4, 5]
		A - What operation do you want?
		p
		[1, 2, 3, 4, 5]
		A - What operation do you want?
		difference
		Enter the 2nd set name:
		C
		The difference of A and C is: [1, 3, 4, 5]

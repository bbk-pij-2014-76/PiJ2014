	Scanner sc = new Scanner(System.in)
        print("Enter an expression: ")
        int  op1 = sc.nextInt()
        String operator = sc.next()
        int op2 = sc.nextInt()

        int output = 0
        if (operator.equals("*")){
             output = op1 * op2
        } else if (operator.equals("+")){
            output = op1 + op2
        }

        println(output)

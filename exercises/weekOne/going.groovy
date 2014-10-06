print "Please input a positive integer, -1 to stop: "
String str = System.console().readLine()
int number = Integer.parseInt(str)
//boolean okay = false
String answer
if (number == -1) 
    answer = "NO"
else
    answer = "YES"

while (number != -1){
    print "Please input a positive integer, -1 to stop: "
    str = System.console().readLine()
    int newNumber = Integer.parseInt(str)
//    println("first number: " + number + " second number " + newNumber)
    if (newNumber != -1 && newNumber != number+1){
        answer = "NO"
    }
    number = newNumber
}
println answer
//print (okay? "YES": "NO")
/**
  * Created by ASUS on 16.11.2016.
  */
class Rational(n: Int, d: Int) { // In Scala the primary constructor is the class’ body and it’s parameter list right after the class name
  //there is no default constructor because the primary constructor can be like a default if we don't pass any parameters on it
  require(d!=0) //this is an pre-condition(assertion) that imposes the restriction on input
  private val g = gcd(n.abs,d.abs)//g is a greatest common divisor, we use it to to reduce a fraction
  var number = n/g //n is a divider
  var denom = d/g //d is a denominator
  def this(n:Int) = this(n,1)
  def + (that: Rational): Rational = new Rational(
    number*that.denom+that.number*denom,denom*that.denom)
  def + (i: Int):Rational = new Rational(
    number+i*denom,denom)
//we need second versions of +,-,* and / to provide the possibility to perform these operations with both integers and rational numbers
  def - (that: Rational): Rational =
    new Rational(number*that.denom - that.number*denom,denom*that.denom)
  def - (i: Int):Rational =
    new Rational(number - i*denom,denom)

  def * (that: Rational): Rational =
    new Rational(number*that.number,denom*that.denom)

  def * (i: Int):Rational =
    new Rational(number*i,denom)
  def / (that: Rational): Rational =
    new Rational(number*that.denom,denom*that.number)
  def / (i: Int):Rational =
    new Rational(number,denom*i)
  override def toString = number + "/" + denom //this class is inherited from Object class, we override toString method to set it the behaviour we need
  private def gcd(a: Int, b: Int): Int = if(b==0) a else gcd(b,a%b)
}

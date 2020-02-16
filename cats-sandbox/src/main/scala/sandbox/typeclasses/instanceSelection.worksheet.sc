// Variance
// Simple definition: Ability to substitute a type with an another type.
// We can say that B is subtype of A of we can use a value of type B anywhere we expect a type A.
// We can define variance annotations to the type parameter to affect the variance of TCs.

// Covariance
// +A means "covariant". It means that F[B] is a subtype of F[A] if B is subtype of A.
// For example we can define any val of List[Circle] anywhere we expect List[Shape], because Circle is a subtype of Shape
// Hint: Use it in collections

sealed trait Shape
case class Circle(radius: Double) extends Shape

val circles: List[Circle] = ???
val shapes: List[Shape] = circles

// Contravariance
// -A means "contravariant". It means that F[B] is subtype of F[A] if A is subtype of B.
// Hint: Use it for modelling types that represent processes.

// Example: Imagine we have a Printer Type Class and we have implemented instances for Circle and Shape
trait Printer[-A] {
  def write(value: A): String
}

val shape1: Shape = ???
val circle1: Circle = ???

val shapePrinter: Printer[Shape] = ???
val circlePrinter: Printer[Circle] = ???

// Given the following generic method (it could be inside an interface object
def format[A](value: A, writer: Printer[A]): String = writer.write(value)

// In order to use format, we have to keep in mind that since any Circle is a Shape we could pass any combination
// of writer and value, but not all the Shapes are Circles, therefore the Printer has to be contravariant
// In other words Printer[Shape] is a subtype of Printer[Circle] because Circle is a subtype of Shape

format(shape1, shapePrinter) // OK
format(shape1, circlePrinter) // WRONG
format(circle1, circlePrinter) // OK
format(circle1, shapePrinter) // OK

// Invariance




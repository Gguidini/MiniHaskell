package br.unb.cic.tp1.mh.ast

import org.scalatest._

class TesteExpAritmeticas extends FlatSpec with Matchers  {

	behavior of "Aritmetic expressions - sum, sub, mul, div, xor, and, or, nor"

  "SUM - An integer value 5 + an integer value 10" should "be evaluated to Valor(15)" in {
    val val5  = ValorInteiro(5)
    val val10 = ValorInteiro(10)

    val soma = ExpSoma(val5, val10)

    soma.avaliar() should be (ValorInteiro(15))
  }

 "SUB - An integer value 10 - an integer value 5" should "be evaluated to Valor(5)" in {
 	val val5  = ValorInteiro(5)
    val val10 = ValorInteiro(10)

    val subtract = ExpSub(val10, val5)

    subtract.avaliar() should be (ValorInteiro(5))
 }

 "MUL - An integer value 10 * an integer value 5" should "be evaluated to Valor(50)" in {
 	val val5  = ValorInteiro(5)
    val val10 = ValorInteiro(10)

    val subtract = ExpMul(val10, val5)

    subtract.avaliar() should be (ValorInteiro(50))
 }

 "DIV - An integer value 10 / an integer value 5" should "be evaluated to Valor(2)" in {
 	val val5  = ValorInteiro(5)
    val val10 = ValorInteiro(10)

    val subtract = ExpDivInt(val10, val5)

    subtract.avaliar() should be (ValorInteiro(2))
 }

 "XOR - An integer value 10 ^ an integer value 5" should "be evaluated to Valor(15)" in {
 	// 10 = b'1010; 5 = b'101; 10^5 = b'1111 = 15
 	val val5  = ValorInteiro(5)
    val val10 = ValorInteiro(10)

    val subtract = ExpXor(val10, val5)

    subtract.avaliar() should be (ValorInteiro(15))
 }

 "AND - An integer value 10 - an integer value 5" should "be evaluated to Valor(0)" in {
 	// 10 = b'01010; 5 = b'00101; 10|5 = b'00000 = 0
 	val val5  = ValorInteiro(5)
    val val10 = ValorInteiro(10)

    val subtract = ExpAnd(val10, val5)

    subtract.avaliar() should be (ValorInteiro(0))
 }

 "OR - An integer value 10 - an integer value 5" should "be evaluated to Valor(15)" in {
 	// 10 = b'01010; 5 = b'00101; 10|5 = b'01111 = 15
 	val val5  = ValorInteiro(5)
    val val10 = ValorInteiro(10)

    val subtract = ExpOr(val10, val5)

    subtract.avaliar() should be (ValorInteiro(15))
 }

 "NOR - An integer value 10 - an integer value 5" should "be evaluated to Valor(-16)" in {
 	// 10 = b'000...01010; 5 = b'000...00101; ~(10|5) = ~(000...01111) = 111...10000 = -16
 	val val5  = ValorInteiro(5)
    val val10 = ValorInteiro(10)

    val subtract = ExpNor(val10, val5)

    subtract.avaliar() should be (ValorInteiro(-16))
 }
}

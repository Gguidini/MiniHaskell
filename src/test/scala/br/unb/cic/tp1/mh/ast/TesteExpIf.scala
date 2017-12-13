package br.unb.cic.tp1.mh.ast

import org.scalatest._
import br.unb.cic.tp1.exceptions.VariavelNaoDeclaradaException
import br.unb.cic.tp1.mh.memoria.Ambiente

// TODO: Add test of the type of the expression
class TesteExpIf extends FlatSpec with Matchers {

	behavior of "an if/else expression"

  it should "execute if condition in if(1+1 == 2) {5+5}" in {
    Ambiente.iniciar()
    val condition = new ExpCondicional(ExpSoma(new ValorInteiro(1),new ValorInteiro(1)), ValorInteiro(2))
    val expIf = new ExpIf(condition, ExpSoma(ValorInteiro(5), ValorInteiro(5)))
    

    expIf.avaliar should be (ValorInteiro(10))
  }

  it should "execute else condition in if(1+1 == 5) {10} else {15}" in {
  	Ambiente.iniciar()
  	val condition = new ExpCondicional(ExpSoma(new ValorInteiro(1),new ValorInteiro(1)), ValorInteiro(5))
    val expIf = new ExpIf(condition, ValorInteiro(10), ValorInteiro(15))

    expIf.avaliar should be (ValorInteiro(15))
  }

  it should "return TErro() for incorrect condition if(1+1 == true)" in {
  	Ambiente.iniciar()
  	val condition = new ExpCondicional(ExpSoma(new ValorInteiro(1),new ValorInteiro(1)), ValorBooleano(true))
    val expIf = new ExpIf(condition, ValorInteiro(10), ValorInteiro(15))

    expIf.verificaTipo should be (TErro())
  }

  it should "return TInt() in if(true) {1+1}" in {
  	Ambiente.iniciar()
  	val condition = new ExpCondicional(ExpSoma(new ValorInteiro(1),new ValorInteiro(1)), ValorInteiro(2))
    val expIf = new ExpIf(condition, ExpSoma(ValorInteiro(1), ValorInteiro(1)), ValorInteiro(15))

    expIf.verificaTipo should be (TInt())
  }

    it should "return TBool() in if(false) {1+1} else {true}" in {
  	Ambiente.iniciar()
  	val condition = new ExpCondicional(ExpSoma(new ValorInteiro(1),new ValorInteiro(1)), ValorInteiro(5))
    val expIf = new ExpIf(condition, ExpSoma(ValorInteiro(1), ValorInteiro(1)), ValorBooleano(true))

    expIf.verificaTipo should be (TBool())
  }


}
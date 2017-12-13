package br.unb.cic.tp1.mh.ast

import org.scalatest._
import br.unb.cic.tp1.exceptions.VariavelNaoDeclaradaException
import br.unb.cic.tp1.mh.memoria.Ambiente

// TODO: Add test of the type of the expression
class TesteExpCondicional extends FlatSpec with Matchers {

	behavior of "a conditional expression"

  it should "return True for (1+1 == 2)" in {
    Ambiente.iniciar()
    val condition = new ExpCondicional(ExpSoma(new ValorInteiro(1),new ValorInteiro(1)), ValorInteiro(2))
    
    condition.avaliar should be (ValorBooleano(true))
  }

    it should "return False for (1+1 == 5)" in {
    	Ambiente.iniciar()
    	val condition = new ExpCondicional(ExpSoma(new ValorInteiro(1),new ValorInteiro(1)), ValorInteiro(5))
    
    	condition.avaliar should be (ValorBooleano(false))
  }

  	it should "return True for (false == false)" in {
  		Ambiente.iniciar()
  		val condition = new ExpCondicional(ValorBooleano(false), ValorBooleano(false))
    
    	condition.avaliar should be (ValorBooleano(true))
  	}

  	it should "return TBool for (1+1 == 2)" in {
  		Ambiente.iniciar()
  		val condition = new ExpCondicional(ExpSoma(new ValorInteiro(1),new ValorInteiro(1)), ValorInteiro(5))
    
    	condition.verificaTipo should be (TBool())
  	}

  	it should "return TBool for (false == false)" in {
  		Ambiente.iniciar()
  		val condition = new ExpCondicional(ValorBooleano(false), ValorBooleano(false))
    
    	condition.verificaTipo should be (TBool())
  	}

	it should "return TErro for (1+1 == true)" in {
  		Ambiente.iniciar()
  		val condition = new ExpCondicional(ExpSoma(new ValorInteiro(1),new ValorInteiro(1)), ValorBooleano(true))
    
    	condition.verificaTipo should be (TErro())
  	}

  	it should "return TErro for (false == 10)" in {
  		Ambiente.iniciar()
  		val condition = new ExpCondicional(ValorBooleano(false), ValorInteiro(10))
    
    	condition.verificaTipo should be (TErro())
  	}  	
}
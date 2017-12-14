package br.unb.cic.tp1.mh.ast

import org.scalatest._
import br.unb.cic.tp1.exceptions.VariavelNaoDeclaradaException
import br.unb.cic.tp1.mh.memoria.Ambiente

// TODO: Add test of the type of the expression
class TesteExpCondList extends FlatSpec with Matchers {

	behavior of "a list of conditional expressions"

	it should "return true in (1+1 == 2 && true==true)" in {
		val cond1 = new ExpCondicional(ExpSoma(ValorInteiro(1), ValorInteiro(1)), ValorInteiro(2))
		val cond2 = new ExpCondicional(ValorBooleano(true), ValorBooleano(true))
		val list = new ExpCondList(List(cond1, cond2), "&&")

		list.avaliar should be (ValorBooleano(true))
	}

	it should "return false in (1+1 == 5 && true==true)" in {
		val cond1 = new ExpCondicional(ExpSoma(ValorInteiro(1), ValorInteiro(1)), ValorInteiro(5))
		val cond2 = new ExpCondicional(ValorBooleano(true), ValorBooleano(true))
		val list = new ExpCondList(List(cond1, cond2), "&&")

		list.avaliar should be (ValorBooleano(false))
	}

		it should "return true in (1+1 == 5 || true==true)" in {
		val cond1 = new ExpCondicional(ExpSoma(ValorInteiro(1), ValorInteiro(1)), ValorInteiro(5))
		val cond2 = new ExpCondicional(ValorBooleano(true), ValorBooleano(true))
		val list = new ExpCondList(List(cond1, cond2), "||")

		list.avaliar should be (ValorBooleano(true))
	}

}
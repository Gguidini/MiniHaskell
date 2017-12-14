package br.unb.cic.tp1.mh.ast

import br.unb.cic.tp1.mh.visitors.PPVisitor
import br.unb.cic.tp1.mh.memoria.Ambiente

import org.scalatest._


class TestePPVisitor extends  FlatSpec with Matchers{

  behavior of "an application of our PPvisitor - making code readable"

  it should "be evaluated to (3 + 4) + 5) when (3+4)+5" in {
    val soma = ExpSoma(ExpSoma(ValorInteiro(3), ValorInteiro(4)),
                                ValorInteiro(5))

    val c = new PPVisitor()

    soma.aceitar(c)

    println(c.sb.toString)
    
    c.sb.toString should be ("((3+4)+5)")
  }

    it should "be evaluated to (3 - 4) - 5) when (3-4)-5" in {
    val soma = ExpSub(ExpSub(ValorInteiro(3), ValorInteiro(4)),
                                ValorInteiro(5))

    val c = new PPVisitor()

    soma.aceitar(c)

    println(c.sb.toString)
    
    c.sb.toString should be ("((3-4)-5)")
  }

  it should "be evaluated to (3 * 4) / 5) when (3*4)/5" in {
    val soma = ExpDivInt(ExpMul(ValorInteiro(3), ValorInteiro(4)),
                                ValorInteiro(5))

    val c = new PPVisitor()

    soma.aceitar(c)

    println(c.sb.toString)
    
    c.sb.toString should be ("((3*4)/5)")
  }

  it should "be evaluated to let x=10 in x" in {
    val exp = new ExpLet("x", ValorInteiro(10), new ExpRef("x"))
    val v = new PPVisitor()

    exp.aceitar(v)

    // output
    println(v.sb.toString)

    v.sb.toString should be ("let x=10 in x")
  }

  it should "be evaluated to if((1+1)==2){(5+10)}" in {
    val cond = new ExpCondicional(ExpSoma(ValorInteiro(1), ValorInteiro(1)), ValorInteiro(2))
    val expIf = new ExpIf(cond, ExpSoma(ValorInteiro(5), ValorInteiro(10)))
    val v = new PPVisitor()

    expIf.aceitar(v)

    // output
    println(v.sb.toString)

    v.sb.toString should be ("if((1+1)==2){\n(5+10)\n}")

  }

it should "be evaluated to if((1+1)!=2){(5+10)}" in {
    val cond = new ExpCondicional(ExpSoma(ValorInteiro(1), ValorInteiro(1)), ValorInteiro(2), ValorBooleano(false))
    val expIf = new ExpIf(cond, ExpSoma(ValorInteiro(5), ValorInteiro(10)))
    val v = new PPVisitor()

    expIf.aceitar(v)

    // output
    println(v.sb.toString)

    v.sb.toString should be ("if((1+1)!=2){\n(5+10)\n}")

  }

  it should "be evaluated to if((1+1)==2){(5+10)}else{20}" in {
    val cond = new ExpCondicional(ExpSoma(ValorInteiro(1), ValorInteiro(1)), ValorInteiro(2))
    val expIf = new ExpIf(cond, ExpSoma(ValorInteiro(5), ValorInteiro(10)), ValorInteiro(20))
    val v = new PPVisitor()

    expIf.aceitar(v)

    // output
    println(v.sb.toString)

    v.sb.toString should be ("if((1+1)==2){\n(5+10)\n}else{\n20\n}")

  }

  it should "be evaluated to (x->(x+1))(5)" in {
    Ambiente.iniciar()
    val inc = new ExpLambda("x", TInt(),new ExpSoma(new ExpRef("x"), ValorInteiro(1)))
    val app = new ExpAplicacaoLambda(inc, ValorInteiro(5)) 
    val v = new PPVisitor()

    app.aceitar(v)
    println(v.sb.toString)
    v.sb.toString should be ("(x->(x+1))(5)")
  }
}

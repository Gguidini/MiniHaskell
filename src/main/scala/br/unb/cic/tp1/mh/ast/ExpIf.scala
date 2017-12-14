package br.unb.cic.tp1.mh.ast

import br.unb.cic.tp1.mh.memoria.Ambiente
import br.unb.cic.tp1.mh.tc.Gamma
import br.unb.cic.tp1.mh.visitors.Visitor

// Expression that returns boolean values and is used in tests
// Maybe teste needs to be another expression, and not a value
class ExpCondicional(val cond : Expressao, val teste : Valor, val testNature : ValorBooleano = ValorBooleano(true)) extends Expressao {

    // condition and test value must be of same type
    override def verificaTipo : Tipo = {
      val valor = cond.avaliar
      if(valor.verificaTipo == teste.verificaTipo){
        return TBool()
      }
      return TErro()
    }

    // returns wether condition is true or false
    override def avaliar : ValorBooleano = {
      val valor = cond.avaliar
      if(testNature.v){
        if(teste == valor){
          return new ValorBooleano(true)
        }
          return new ValorBooleano(false)
      }
      else{
        if(teste == valor){
        return new ValorBooleano(false)
        }
        return new ValorBooleano(true)
      }
    }

    override def aceitar(v : Visitor): Unit = {
      v.visitar(this)
    }

}

class ExpIf(val cond : ExpCondicional, val corpoIf : Expressao, val corpoElse : Expressao = null) extends Expressao {

override def avaliar(): Valor = {
  // returns evaluation of correct expression, or nothing
    if(cond.avaliar.v)
      corpoIf.avaliar
    else if(corpoElse != null)
      corpoElse.avaliar
    else
      null
  }

  override def verificaTipo: Tipo = {
    // returns type of evaluated expression
    if(cond.verificaTipo == TErro())
      return TErro()

    if(cond.avaliar.v)
      return corpoIf.verificaTipo
    else
      return corpoElse.verificaTipo
  }

  override def aceitar(v: Visitor): Unit = {
    v.visitar(this)
  }
}

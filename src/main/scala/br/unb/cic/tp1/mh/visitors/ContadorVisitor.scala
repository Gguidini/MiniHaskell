package br.unb.cic.tp1.mh.visitors
import br.unb.cic.tp1.mh.ast._

class ContadorVisitor extends Visitor {

  var contador = 0

  override def visitar(exp: ValorInteiro): Unit = contador += 1

  override def visitar(exp: ValorBooleano): Unit = contador += 1

  override def visitar(exp: ExpAritmetica): Unit = {
    exp.lhs.aceitar(this)
    exp.rhs.aceitar(this)
    contador += 1
  }

  override def visitar(exp: ExpLet): Unit = {
    exp.expNomeada.aceitar(this)
    exp.corpo.aceitar(this)
    contador += 1
  }

  override def visitar(exp: ExpLambda): Unit = {
    exp.corpo.aceitar(this)
    contador += 1
  }

  override def visitar(exp: ExpAplicacaoLambda): Unit = {
    exp.exp1.aceitar(this)
    exp.exp2.aceitar(this)
    contador += 1
  }

  override def visitar(exp: ExpAplicacaoNomeada): Unit = {
    exp.argumentoAtual.aceitar(this)
    contador += 1
  }

  override def visitar(exp: ExpRef): Unit = contador += 1

  override def visitar(exp: Closure): Unit = {
    exp.corpo.aceitar(this)
    contador += 1
  }

  override def visitar(exp: ExpCondicional) : Unit = {
    exp.teste.aceitar(this)
    exp.cond.aceitar(this)
    contador += 1
  }
  
  override def visitar(exp: ExpIf) : Unit = {
    exp.cond.aceitar(this)
    exp.corpoIf.aceitar(this)
    if(exp.corpoElse != null)
      exp.corpoElse.aceitar(this)
    contador += 1
  }
}

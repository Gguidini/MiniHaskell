package br.unb.cic.tp1.mh.ast

import br.unb.cic.tp1.mh.memoria.Ambiente
import br.unb.cic.tp1.mh.visitors.Visitor

class ExpLet(val id : String, val expNomeada : Expressao, val corpo : Expressao) extends Expressao {

  override def avaliar(): Valor = {
    val valor = expNomeada.avaliar() // innermost strategy
    Ambiente.atualiza(id, valor)
    return corpo.avaliar()
  }

  override def verificaTipo: Tipo = TErro()

  override def aceitar(v: Visitor): Unit = {
    v.visitar(this)
  }
}

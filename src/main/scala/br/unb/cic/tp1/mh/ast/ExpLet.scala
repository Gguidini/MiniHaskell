package br.unb.cic.tp1.mh.ast

import br.unb.cic.tp1.mh.memoria._

class ExpLet(val id : String, val expNomeada : Expressao, val corpo : Expressao) extends Expressao {

  override def avaliar(): Valor = {
    val valor = expNomeada.avaliar() // innermost strategy
    Ambiente.atualiza(id, valor)
    return corpo.avaliar()
  }

  override def verificaTipo(): Tipo = {
    return corpo.verificaTipo()
  }
}

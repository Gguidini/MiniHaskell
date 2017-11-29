package br.unb.cic.tp1.mh.ast

import br.unb.cic.tp1.mh.memoria.Ambiente

class ExpAplicacaoNomeada(val nome: String, argumentoAtual : Expressao) extends Expressao {

  override def avaliar(): Valor = {
    val decFuncao = Ambiente.recuperarFuncao(nome)

    Ambiente.novoAmbiente()
    Ambiente.atualiza(decFuncao.argFormal, argumentoAtual.avaliar())

    val res = decFuncao.corpo.avaliar()

    Ambiente.removeAmbiente()

    return res
  }

  override def verificaTipo(): Tipo = {
    return argumentoAtual.verificaTipo()
  }
}

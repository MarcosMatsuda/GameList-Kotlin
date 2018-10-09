package br.com.marcos.matsuda.adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.marcos.matsuda.meusjogos.R
import br.com.marcos.matsuda.model.Jogo
import kotlinx.android.synthetic.main.meu_jogo_item.view.*

class JogoAdapter (
        private val context: Context,
        private val jogos: List<Jogo>,
        val listener: (Jogo) -> Unit
    ) : RecyclerView.Adapter<JogoAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val jogo = jogos[position]
        holder?.let {
            it.bindView(jogo, listener)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.meu_jogo_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return jogos.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(jogo: Jogo,
                     listener: (Jogo) -> Unit) = with(itemView) {

            val ivJogo = ivJogo
            val tvTitulo = tvTitulo
            val tvAnoLancamento = tvAnoLancamento
            val tvDescricao = tvDescricao

            ivJogo.setImageDrawable(ContextCompat.getDrawable(context, jogo.resourceId))
            tvTitulo.text = jogo.titulo
            tvAnoLancamento.text = jogo.anoLancamento.toString()
            tvDescricao.text = jogo.descricao

            setOnClickListener { listener(jogo) }

        }

    }

    interface ClickListener {
        fun onClick(view: View, position: Int)
    }

}
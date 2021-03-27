import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Categoria } from '../model/Categoria';
import { Produto } from '../model/Produto';
import { CategoriaService } from '../service/categoria.service';
import { ProdutoService } from '../service/produto.service';

@Component({
  selector: 'app-loja-categoria',
  templateUrl: './loja-categoria.component.html',
  styleUrls: ['./loja-categoria.component.css']
})
export class LojaCategoriaComponent implements OnInit {

  listaProdutos: Produto[]
  listaProdutosFiltrada: Produto[]
  produto: Produto = new Produto()
  tituloProdutoCategoria: string
  generoProduto: string

  listaCategoria: Categoria[]
  listaCategoriaFiltrada: Produto[]

  key = 'genero'
  reverse = false

  constructor(
    private produtoService: ProdutoService,
    private categoriaService: CategoriaService,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    window.scroll(0, 0)
    this.findAllCategoria()
    this.getAllProdutos()


    this.generoProduto = this.route.snapshot.params['genero']
    this.findByGeneroProduto(this.generoProduto)

  }

  findByGeneroProduto(cat: string) {
    this.produtoService.getByGeneroProduto(cat).subscribe((resp: Produto[]) => {
      this.listaCategoriaFiltrada = resp
    })
  }


  findAllCategoria() {
    this.categoriaService.getAllCategoria().subscribe((resp: Categoria[]) => {
      this.listaCategoria = resp
    })
  }

  getAllProdutos() {
    this.produtoService.getAllProdutos().subscribe((resp: Produto[]) => {
      this.listaProdutos = resp
    })
  }

  findByTituloProdutoCategoria() {
    if (this.tituloProdutoCategoria == '') {
      this.findByGeneroProduto(this.generoProduto)
    } else {
      //filter pesquisa em this.tituloProdutoCategoria conforme o que é escrito. gerando um array novo atribuindo tudo ao atributo da esquerda da função
      this.listaCategoriaFiltrada = this.listaCategoriaFiltrada.filter(produtoGenero =>
        produtoGenero.nome.toLowerCase().indexOf(this.tituloProdutoCategoria.toLowerCase()) != -1)
    }
  }

}
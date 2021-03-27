import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Categoria } from '../model/Categoria';
import { Produto } from '../model/Produto';
import { CategoriaService } from '../service/categoria.service';
import { ProdutoService } from '../service/produto.service';

@Component({
  selector: 'app-loja',
  templateUrl: './loja.component.html',
  styleUrls: ['./loja.component.css']
})
export class LojaComponent implements OnInit {

  listaProdutos: Produto[]
  tituloProduto: string
  generoCategoria: Categoria[]

  listaCategoria: Categoria[]

  key = 'genero'
  reverse = false

  constructor(
    private produtoService: ProdutoService,
    private categoriaService: CategoriaService,
  ) { }

  ngOnInit() {
    window.scroll(0, 0)
    this.getAllProdutos()
    this.findAllCategoria()


  }

  getAllProdutos() {
    this.produtoService.getAllProdutos().subscribe((resp: Produto[]) => {
      this.listaProdutos = resp
    })
  }

  findAllCategoria() {
    this.categoriaService.getAllCategoria().subscribe((resp: Categoria[]) => {
      this.listaCategoria = resp
    })
  }

  findByTituloProduto() {
    if (this.tituloProduto == '') {
      this.getAllProdutos()
    } else {
      this.produtoService.getByTituloProduto(this.tituloProduto).subscribe((resp: Produto[]) => {
        this.listaProdutos = resp
      })
    }
  }

}
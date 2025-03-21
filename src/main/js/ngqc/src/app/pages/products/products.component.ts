import { Component } from '@angular/core';

import { MArticle } from '../../models/facades/marticle';

@Component({
  selector: 'app-products',
  standalone: false,
  templateUrl: './products.component.html',
  styleUrl: './products.component.scss',
})
export class ProductsComponent {
  article: MArticle = {
    id: '',
    title: '',
    description: '',
  };
}

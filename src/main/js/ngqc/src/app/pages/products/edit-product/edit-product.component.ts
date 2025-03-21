import { Component, inject } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-edit-product',
  standalone: false,
  templateUrl: './edit-product.component.html',
  styleUrl: './edit-product.component.scss',
})
export class EditProductComponent {
  private formBuilder = inject(FormBuilder);

  productForm = this.formBuilder.group({
    title: ['', Validators.required],
    description: ['', Validators.required],
  });

  updateProduct() {
    this.productForm.patchValue({
      title: '',
      description: '',
    });
  }

  onSubmit() {
    console.warn(this.productForm.value);
  }
}

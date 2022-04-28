import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { DashboardComponent } from './pages/admin/dashboard/dashboard.component';
import { AdminGuardGuard } from './services/admin-guard.guard';
import { ViewCategoriesComponent } from './pages/admin/view-categories/view-categories.component';
import { AddCategoryComponent } from './pages/admin/add-category/add-category.component';
import { AddProductComponent } from './pages/admin/add-product/add-product.component';
import { ViewProductsComponent } from './pages/admin/view-products/view-products.component';
import { UserListComponent } from './pages/admin/user-list/user-list.component';
import { ShopComponent } from './pages/shop/shop.component';
import { ProductComponent } from './pages/product/product.component';
import { ProductOutletComponent } from './pages/product-outlet/product-outlet.component';
import { CartComponent } from './pages/cart/cart.component';
import { CartGuardGuard } from './services/cart-guard.guard';
import { PurchasesComponent } from './pages/purchases/purchases.component';
import { PurchaseComponent } from './pages/admin/purchase/purchase.component';
import { AdminLoginComponent } from './pages/admin-login/admin-login.component';

const routes: Routes = [
  { path: '', component: HomeComponent, pathMatch: 'full' },
  { path: 'login', component: LoginComponent, pathMatch: 'full' },
  { path: 'admin-login', component: AdminLoginComponent, pathMatch: 'full' },
  { path: 'signup', component: RegisterComponent, pathMatch: 'full' },
  {
    path: 'products',
    component: ProductOutletComponent,
    children: [
      { path: '', component: ShopComponent },
      {
        path: 'cart',
        component: CartComponent,
        canActivate: [CartGuardGuard],
        pathMatch: 'full',
      },
      {
        path: 'orders',
        component: PurchasesComponent,
        canActivate: [CartGuardGuard],
        pathMatch: 'full',
      },
      { path: ':productId', component: ProductComponent },
    ],
  },
  {
    path: 'admin',
    component: DashboardComponent,
    canActivate: [AdminGuardGuard],
    children: [
      { path: '', component: ViewProductsComponent },
      { path: 'categories', component: ViewCategoriesComponent },
      { path: 'add-category', component: AddCategoryComponent },
      { path: 'products', component: ViewProductsComponent },
      { path: 'add-product', component: AddProductComponent },
      { path: 'users', component: UserListComponent },
      { path: 'purchase-reports', component: PurchaseComponent },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}

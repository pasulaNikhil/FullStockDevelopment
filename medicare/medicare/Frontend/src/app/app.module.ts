import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { authInterceptorProviders } from './services/authInterceptor';
import { LoginServicesService } from './services/login-services.service';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatButtonModule } from '@angular/material/button';
import { MatListModule } from '@angular/material/list';
import { MatCardModule } from '@angular/material/card';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { HomeComponent } from './pages/home/home.component';
import { RouterModule } from '@angular/router';
import { DashboardComponent } from './pages/admin/dashboard/dashboard.component';
import { AddCategoryComponent } from './pages/admin/add-category/add-category.component';
import { ViewCategoriesComponent } from './pages/admin/view-categories/view-categories.component';
import { AddProductComponent } from './pages/admin/add-product/add-product.component';
import { ViewProductsComponent } from './pages/admin/view-products/view-products.component';
import { AdminSidebarComponent } from './components/admin-sidebar/admin-sidebar.component';
import { MatOptionModule } from '@angular/material/core';
import { MatSelectModule } from '@angular/material/select';
import { MatTableModule } from '@angular/material/table';
import { ProductServicesService } from './services/product-services.service';
import { CategoryServiceService } from './services/category-service.service';
import { UserServiceService } from './services/user-service.service';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { UserListComponent } from './pages/admin/user-list/user-list.component';
import { ShopComponent } from './pages/shop/shop.component';
import { ProductComponent } from './pages/product/product.component';
import { ProductOutletComponent } from './pages/product-outlet/product-outlet.component';
import { AdminLoginComponent } from './pages/admin-login/admin-login.component';
import { CartComponent } from './pages/cart/cart.component';
import { PurchasesComponent } from './pages/purchases/purchases.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { PurchaseComponent } from './pages/admin/purchase/purchase.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    DashboardComponent,
    AddCategoryComponent,
    ViewCategoriesComponent,
    AddProductComponent,
    ViewProductsComponent,
    AdminSidebarComponent,
    UserListComponent,
    ShopComponent,
    ProductComponent,
    ProductOutletComponent,
    AdminLoginComponent,
    CartComponent,
    PurchasesComponent,
    ProfileComponent,
    PurchaseComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    HttpClientModule,
    NgbModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    HttpClientModule,
    MatSnackBarModule,
    MatToolbarModule,
    MatIconModule,
    MatListModule,
    MatCardModule,
    MatOptionModule,
    MatSelectModule,
    MatTableModule,
    MatPaginatorModule,
  ],
  providers: [
    authInterceptorProviders,
    LoginServicesService,
    ProductServicesService,
    CategoryServiceService,
    UserServiceService,
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}

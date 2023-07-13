    <aside class="main-sidebar sidebar-dark-primary elevation-4">
      <!-- Brand Logo -->
      <a href="index3.html" class="brand-link">
        <span class="brand-text font-weight-light">Together.co.LTD</span>
      </a>

      <!-- Sidebar -->
      <div class="sidebar">

        <!-- SidebarSearch Form -->
        <div class="form-inline">
          <div class="input-group" data-widget="sidebar-search">
            <input class="form-control form-control-sidebar" type="search" placeholder="Search" aria-label="Search">
            <div class="input-group-append">
              <button class="btn btn-sidebar">
                <i class="bi bi-search"></i>
              </button>
            </div>
          </div>
        </div>

        <!-- Sidebar Menu -->
        <nav class="mt-4">
          <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
            <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
            <li class="nav-item">
              <c:url value="/admin/userList" var="userList"></c:url>
              <a href="${userList}" class="nav-link">
                <p class="p-1">Users</p>
                <i class="bi bi-person float-right"></i>
              </a>
            </li>
            <li class="nav-item">
              <c:url value="/admin/shopList" var="shopList"></c:url>
              <a href="${shopList}" class="nav-link">
                <p class="p-1">Shops</p>
                <i class="bi bi-shop-window float-right"></i> 
              </a>
            </li>
          </ul>
        </nav>
        <!-- /.sidebar-menu -->
      </div>
      <!-- /.sidebar -->
    </aside>
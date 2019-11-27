<helpset version="1.0">
   <title>Ayuda - Aplicación Ingresos y Gastos</title>
   <maps>
      <!-- Pagina por defecto al mostrar la ayuda -->
      <homeID>aplicacion</homeID>
      <!-- Que mapa deseamos -->
      <mapref location="map_file.jhm"/>
   </maps>

   <!-- Las Vistas que deseamos mostrar en la ayuda -->
   <!-- La tabla de contenidos -->
   <view>
      <name>Tabla Contenidos - Aplicación Ingresos y Gastos</name>
      <label>Tabla de contenidos</label>
      <type>javax.help.TOCView</type>
      <data>toc.xml</data>
   </view>

   <!-- El indice -->
   <view>
      <name>Indice - Aplicación Ingresos y Gastos</name>
      <label>El indice</label>
      <type>javax.help.IndexView</type>
      <data>indice.xml</data>
   </view>

   <!-- La pestana de busqueda -->
   <view>
      <name>Busqueda - Aplicación Ingresos y Gastos</name>
      <label>Buscar</label>
      <type>javax.help.SearchView</type>
      <data engine="com.sun.java.help.search.DefaultSearchEngine">
         JavaHelpSearch
      </data>
   </view>

</helpset>

   $(document).ready(function () {
     $('#dt-horizontal-scroll').dataTable({
       "fnInitComplete": function () {
         var myCustomScrollbar = document.querySelector('#dt-horizontal-scroll_wrapper .dataTables_scrollBody');
         var ps = new PerfectScrollbar(myCustomScrollbar);
       },
       "scrollX": true,
       fixedColumns:   {
         leftColumns: 1,
         rightColumns: 1
     }
     });
   });
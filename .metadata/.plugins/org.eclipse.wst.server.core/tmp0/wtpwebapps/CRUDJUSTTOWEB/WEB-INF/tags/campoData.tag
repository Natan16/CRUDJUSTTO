<%@ attribute name="id" required="true" %>

<input id="${id}" name="${id}" type="text" placeholder="dd/mm/aaaa" >
<script>
    $( "#${id}").datepicker({yearRange: "-80:+00", changeYear : true ,  changeMonth: true});
    //$( "#${id}" ).datepicker( "option", "minDate", new Date(1920, 1 - 1, 1) );
    //$( "#${id}" ).datepicker( "option", "maxDate", new Date(2007, 1 - 1, 1) );
   
</script>

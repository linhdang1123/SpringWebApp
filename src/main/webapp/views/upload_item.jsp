<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
<link rel="stylesheet" href="/resources/css/uploaditem.css">
<script language="javascript">
/* When the user clicks on the button,
toggle between hiding and showing the dropdown content */
function myFunction() {

  document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown menu if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {
    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}

function getSubcategory() {
		var mycategory;
		mycategory = document.getElementById("category").value;		
		if (mycategory=="Clothes") {
			clothesCheckbox.classList.remove('hide');
		    bagsCheckbox.classList.add('hide'); 
		    accessoriesCheckbox.classList.add('hide'); 
		    topsCheckbox.classList.add('hide');
		    bottomsCheckbox.classList.add('hide'); 
		    sweatersCheckbox.classList.add('hide'); 
		    jacketsCheckbox.classList.add('hide'); 
		    dressesCheckbox.classList.add('hide'); 
		}
		if (mycategory=="Bags") {
			clothesCheckbox.classList.add('hide');
		    bagsCheckbox.classList.remove('hide'); 
		    accessoriesCheckbox.classList.add('hide');
		    topsCheckbox.classList.add('hide');
		    bottomsCheckbox.classList.add('hide'); 
		    sweatersCheckbox.classList.add('hide'); 
		    jacketsCheckbox.classList.add('hide'); 
		    dressesCheckbox.classList.add('hide');  
		}
		if (mycategory=="Accessories") {
			clothesCheckbox.classList.add('hide');
		    bagsCheckbox.classList.add('hide'); 
		    accessoriesCheckbox.classList.remove('hide'); 
		    topsCheckbox.classList.add('hide');
		    bottomsCheckbox.classList.add('hide'); 
		    sweatersCheckbox.classList.add('hide'); 
		    jacketsCheckbox.classList.add('hide'); 
		    dressesCheckbox.classList.add('hide'); 
		}
	
}

function getClothesSubcategory(mycategory) {		
	if (mycategory=="tops") {
		topsCheckbox.classList.remove('hide');
	    bottomsCheckbox.classList.add('hide'); 
	    sweatersCheckbox.classList.add('hide'); 
	    jacketsCheckbox.classList.add('hide'); 
	    dressesCheckbox.classList.add('hide'); 
	}
	if (mycategory=="bottoms") {
		topsCheckbox.classList.add('hide');
	    bottomsCheckbox.classList.remove('hide'); 
	    sweatersCheckbox.classList.add('hide'); 
	    jacketsCheckbox.classList.add('hide'); 
	    dressesCheckbox.classList.add('hide'); 
	}
	if (mycategory=="jackets") {
		topsCheckbox.classList.add('hide');
	    bottomsCheckbox.classList.add('hide'); 
	    sweatersCheckbox.classList.remove('hide'); 
	    jacketsCheckbox.classList.add('hide'); 
	    dressesCheckbox.classList.add('hide'); 
	}
	if (mycategory=="sweaters") {
		topsCheckbox.classList.add('hide');
	    bottomsCheckbox.classList.add('hide'); 
	    sweatersCheckbox.classList.add('hide'); 
	    jacketsCheckbox.classList.remove('hide'); 
	    dressesCheckbox.classList.add('hide'); 
	}
	if (mycategory=="dresses") {
		topsCheckbox.classList.add('hide');
	    bottomsCheckbox.classList.add('hide'); 
	    sweatersCheckbox.classList.add('hide'); 
	    jacketsCheckbox.classList.add('hide'); 
	    dressesCheckbox.classList.remove('hide');
	}

}


</script>
</head>
<body>

<div class="container" id="container">
	<div class="form-container sign-in-container">
		<form action="uploadItem">
			<h1>Form</h1>
			<div class="social-container">
			</div>
			<label for="img">Please upload an image of your item:</label>
  			<input type="file" id="img" name="image" accept="image/*" required>
			<div class="dropdown">
          		<select id="category" name="category" onchange="getSubcategory()" required>
					<option value="None">-- Select Category --</option>
					<option value="Clothes" >Clothes</option>
					<option value="Bags" >Bags</option>
					<option value="Accessories">Accessories</option>
				</select>
			</div>
			<fieldset class="hide" id="clothesCheckbox" name="clothesCheckbox">
			    <p>Choose subcategories of clothes for your item.</p>
			    <p>
			        <label><input type="radio" name="categorySubfield" value="tops" onclick="getClothesSubcategory('tops')"/> tops</label>
			        <label><input type="radio" name="categorySubfield" value="bottoms" onclick="getClothesSubcategory('bottoms')"/> bottoms</label>
			        <label><input type="radio" name="categorySubfield" value="jackets" onclick="getClothesSubcategory('jackets')"/> jackets</label>
			        <label><input type="radio" name="categorySubfield" value="sweaters" onclick="getClothesSubcategory('sweaters')"/> sweaters</label>
			        <label><input type="radio" name="categorySubfield" value="dresses" onclick="getClothesSubcategory('dresses')"/> dresses</label>
			    </p>
			    
		    </fieldset>
		    <fieldset class="hide" id="bagsCheckbox" name="bagsCheckbox">
			    <p>Choose subcategories of bags for your item.</p>
			    <p>
			        <label><input type="radio" name="categorySubfield" value="crossbody" /> crossbody</label>
			        <label><input type="radio" name="categorySubfield" value="handle" /> handle</label>
			    </p>
			    
		    </fieldset>
		    <fieldset class="hide" id="accessoriesCheckbox" name="accessoriesCheckbox">
			    <p>Choose subcategories of accessories for your item.</p>
			    <p>
			        <input type="radio" name="categorySubfield" value="watches" > watches
			        <input type="radio" name="categorySubfield" value="socks" > socks
			        <input type="radio" name="categorySubfield" value="belts" > belts
			        <input type="radio" name="categorySubfield" value="hair" > hair
			     </p>
		    </fieldset>
		    <fieldset class="hide" id="topsCheckbox">
			    <p>Choose subcategories of tops for your item.</p>
			    <p>
			        <input type="radio" name="categorySubsubfield" value="off-shoulder" > off-shoulder
			        <input type="radio" name="categorySubsubfield" value="tank" > tank
			        <input type="radio" name="categorySubsubfield" value="t-shirt" > t-shirt
			        <input type="radio" name="categorySubsubfield" value="half-sleeve" > half-sleeve
			        <input type="radio" name="categorySubsubfield" value="long-sleeve" > long-sleeve
			     </p>
		    </fieldset>
		    <fieldset class="hide" id="bottomsCheckbox">
			    <p>Choose subcategories of bottoms for your item.</p>
			    <p>
			        <input type="radio" name="categorySubsubfield" value="dress" > Dress
			        <input type="radio" name="categorySubsubfield" value="jeans" > Jeans
			        <input type="radio" name="categorySubsubfield" value="leggings" > Leggings
			        <input type="radio" name="categorySubsubfield" value="skirt" > Skirt
			        <input type="radio" name="categorySubsubfield" value="shorts" > Shorts
			        <input type="radio" name="categorySubsubfield" value="ankle-length" > Ankle-length
			     </p>
		    </fieldset>
		    <fieldset class="hide" id="jacketsCheckbox">
			    <p>Choose subcategories of jackets for your item.</p>
			    <p>
			        <input type="radio" name="categorySubsubfield" value="denim" > Denim
			        <input type="radio" name="categorySubsubfield" value="trench" > Trench
			        <input type="radio" name="categorySubsubfield" value="rain" > Rain
			        <input type="radio" name="categorySubsubfield" value="leather" > Leather
			        <input type="radio" name="categorySubsubfield" value="puffer" > Puffer
			        <input type="radio" name="categorySubsubfield" value="ankle-length" > Ankle-length
			     </p>
		    </fieldset>
		    <fieldset class="hide" id="sweatersCheckbox">
			    <p>Choose subcategories of sweaters for your item.</p>
			    <p>
			        <input type="radio" name="categorySubsubfield" value="pullover" > Pullover
			        <input type="radio" name="categorySubsubfield" value="turtleneck" > Turtleneck/Crewneck
			        <input type="radio" name="categorySubsubfield" value="poncho" > Poncho
			        <input type="radio" name="categorySubsubfield" value="cardigan" > Cardigan
			     </p>
		    </fieldset>
		    <fieldset class="hide" id="dressesCheckbox">
			    <p>Choose subcategories of dresses for your item.</p>
			    <p>
			        <input type="radio" name="categorySubsubfield" value="formal" > Formal
			        <input type="radio" name="categorySubsubfield" value="short" > Short
			        <input type="radio" name="categorySubsubfield" value="midi" > Midi
			        <input type="radio" name="categorySubsubfield" value="maxi" > Maxi
			     </p>
		    </fieldset>
			<input type="text" placeholder="Enter item name" name = "name" required/>
			<input type="number" step="0.01" placeholder="Enter price"  name = "price" required/>
      		<input type="text" placeholder="Enter description" name = "description" required/>

			<button>Upload Item Information</button>
		</form>
	</div>
</div>
</body>
</html>
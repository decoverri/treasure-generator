<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<footer class="container footer">
	<ul class="footer-content" >
		<li class="footer-item footer-about"><a href="<c:url value="/about"/>" >About</a></li>
		<li class="footer-item footer-credits"><a href="<c:url value="/credits"/>" >Credits</a></li>
	</ul>
		
	<ul class="footer-content contacts" >
		<li class="footer-item">created by <a class="me" href="http://decoverri.com" >Deco Verri</a></li>
		<li class="footer-item"><a class="footer-icon github" href="http://github.com/decoverri" >Github</a></li>
		<li class="footer-item"><a class="footer-icon twitter" href="http://twitter.com/decoverri" >Twitter</a></li>
	</ul>
</footer>

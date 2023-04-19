window.addEventListener('scroll', function () {
     let offset = window.pageYOffset;
      document.querySelector('.image-1').style.backgroundPositionY = offset * 0.1 + 'px';
       document.querySelector('.image-2').style.backgroundPositionY = offset * 0.1 + 'px';
        document.querySelector('.image-3').style.backgroundPositionY = offset * 0.1 + 'px'; 
    });

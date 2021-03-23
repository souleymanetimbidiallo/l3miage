<?php
    class User {
        private $nom;
        private $prenom;
        private $age;
        private $email;
        private $motDePasse;

        /** CONSTRUCTEURS */
        function __construct(){
            $num=func_num_args();
 
   switch($num)
   {
      case 1:
         //un seul paramètre passé
         $this->var1=func_get_arg(0);
         break;
      case 2:
         //deux paramètres passés
         $this->var1=func_get_arg(0);
         $this->var2=func_get_arg(1);
         break;
      default:
   }
		// Trucs à initialiser communs aux deux constructions
	    }

        /**AUTRES METHODES*/
        public function vieillir($annee){
            $this->age += $annee;
        }

        /** GETTERS et SETTERS */
        public function getNom(){
            return $this->nom;
        }

        public function setNom($nom){
            return $this->nom = $nom;
        }
        
        public function getPrenom(){
            return $this->prenom;
        }
        
        public function setPrenom($prenom){
            return $this->prenom = $prenom;
        }
        
        public function getAge(){
            return $this->age;
        }

        public function setAge($age){
            return $this->age = $age;
        }
        
        public function getEmail(){
            return $this->email;
        }

        public function setEmail($email){
            return $this->email = $email;
        }
        
        public function getMotDePasse(){
            return $this->motDePasse;
        }

        public function setMotDePasse($password){
            return $this->motDePasse = $password;
        }
    }
?>
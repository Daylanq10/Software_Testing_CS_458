<?php
class Blocks{
	
	private $ontables = array();
	private $clears = array();
	private $ons = array();
	private $holding = null;
	private $handempty = true;
	
	public function __construct(){
		
	}
	
	public function pickup($a){
				
		if (in_array($a, $this->ontables) && in_array($a, $this->clears) && $this->handempty){
			
			self::arrayRemoveElement($this->ontables, $a);			
			self::arrayRemoveElement($this->clears, $a);
			$this->handempty = false;
			$this->holding = $a;
		}
		else
			echo "Cannot pickup ".$a;
	}
	
	public function putdown($a){
		if (!is_null($this->holding)){
			$this->holding = null;
			$this->ontables[]=$a;
			$this->clears[]=$a;
			$this->handempty = true;
		}
		else
			echo "Cannot put down ".a;
	}
	
	public function stack($a, $b){
		if ($a!=$b && !is_null($this->holding) && $this->holding==$a && in_array($b,$this->clears)){
			$this->handempty=true;
			$this->ons[]=new ON($a,$b);
			self::arrayRemoveElement($this->clears, $b);			
			$this->clears[]=$a;
			$this->holding = null;
		}
		else
			echo "Cannot stack ".a." on ".b;
	}
	
	public function unstack($a,$b){
		if ($this->handempty && in_array($a, $this->clears) && $this->isOn($a, $b)){
			$this->handempty = false;
			self::arrayRemoveElement($this->clears, $a);			
			$this->removeOn($a, $b);
			$this->holding = $a;
			$this->clears[]=$b;
		}
		else
			echo "Cannot unstack ".$a." from ".$b;
	}
	
	public function getOntables(){
		return $this->ontables;
	}
	
	public function isOntable($a){
		return in_array($a, $this->ontables);
	}
	
	public function getClears(){
		return $this->clears;
	}
	
	public function isClear($a){
		return in_array($a, $this->clears);
	}
	
	public function getOns(){
		return $this->ons;
	}
	
	public function isOn($a, $b){
		$on2 = new ON($a, $b);
		foreach($this->ons as $on)
		if ($on==$on2)
			return true;
		return false;
	}
	
	private function removeOn($a, $b){
		$on2 = new ON($a, $b);		
		foreach ($this->ons as $key => $value) {
			if($value==$on2)
				unset ($this->ons[$key]);				
		}
		
	}
	
	public function getHolding(){
		return $this->holding;
	}
	
	public function isHolding($thing){
		return $this->holding!=null && $this->holding=$thing;
	}
	
	public function isHandempty(){
		return $this->handempty;
	}
	
	public function setHandempty($empty){
		$this->handempty = $empty;
	}
	
	public function toString(){
		$str = "";
				
		foreach ($this->ontables as $ontable)
			$str .= "\n\tontable(".$ontable.")";
		
		foreach ($this->clears as $clear)
			$str .= "\n\tclear(".$clear.")";
		
		foreach ($this->ons as $on)
			$str .= "\n\t".$on->toString();
		
		if (!is_null($this->holding))
			$str .= "\n\tholding(".$this->holding.")";
		
		if ($this->handempty)
			$str .= "\n\thandempty(\"r\")";
		
		return $str;
	}
	
	public function init(){
		
		$this->ontables[]=3;
		$this->ontables[]=6;
		
		$this->clears[]=1;
		$this->clears[]=6;
		
		$this->ons[]=new ON(1, 3);
		$this->handempty = true;
				
	}	
	
	// EXTRAS
	
	/**
	 * Simulation of arrayList.remove()
	 * @param Array $array
	 * @param int $elToRemove
	 */
	public static function arrayRemoveElement($array,$elToRemove){
		
		foreach ($array as $key => $value) {
			if($value==$elToRemove)
				unset ($array[$key]);
			
		}
	}
	
	public function addToArray($array,$elToAdd){
	
		$this->{$array}[]=$elToAdd;
		
		
	
	}
	
}
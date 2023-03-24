package fr.ablanc.qualidev

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import fr.ablanc.qualidev.databinding.ActivityMainBinding
import fr.ablanc.qualidev.model.Card
import fr.ablanc.qualidev.model.CardType
import fr.ablanc.qualidev.model.magic.MagicCard
import fr.ablanc.qualidev.model.pokemon.Attack
import fr.ablanc.qualidev.model.pokemon.PokemonCard
import fr.ablanc.qualidev.model.pokemon.Type

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val pikachuAttack1 = Attack(10,25,"Pikachu Attack 1");
        val pikachuAttack2 = Attack(23,48,"Pikachu Attack 2");
        val pikachuAttackArray = arrayOf(pikachuAttack1,pikachuAttack2);
        val pikachu = PokemonCard(Type.Electric,12,pikachuAttackArray,"Rare", 12, "Pikachu", CardType.Pokemon);
        Log.i("pikachu", pikachu.toString());

        val magicCardAttack = fr.ablanc.qualidev.model.magic.Attack(12,23,"Magic Card Attack 1");
        val magicCard = MagicCard(10,45,fr.ablanc.qualidev.model.magic.Type.Vanguard,"Normal", magicCardAttack,"MagicCard", CardType.Magic);

        val list: MutableList<Card> = ArrayList()
        list.add(pikachu)
        list.add(magicCard)
        Log.i("Taille tableau", (list.size).toString())

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    fun sortByCardType(cardList : ArrayList<Card>, firtElementType : CardType) : ArrayList<Card>{
        var sortedList : ArrayList<Card> = ArrayList<Card>();
        cardList.forEach(){
            if(it.cardType == firtElementType){
                sortedList.add(it);
                cardList.remove(it);
            }
        }

        sortedList.addAll(sortedList.lastIndex + 1,cardList);

        return sortedList;
    }
}
package TEssentials.Utilidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryIO
{
  @SuppressWarnings("deprecation")
public static Inventory loadFromTextfile(File file)
    throws IOException
  {
    Inventory inventory = Bukkit.getServer().createInventory(null, 54);
    
    BufferedReader in = new BufferedReader(new FileReader(file));
    
    int slot = 0;
    String line;
    while ((line = in.readLine()) != null) {
      if (!line.equals(""))
      {
        String[] parts = line.split(":");
        try
        {
          int type = Integer.parseInt(parts[0]);
          int amount = Integer.parseInt(parts[1]);
          short damage = Short.parseShort(parts[2]);
          if (type != 0) {
            inventory.setItem(slot, new ItemStack(type, amount, damage));
          }
        }
        catch (NumberFormatException e) {}
        slot++;
      }
    }
    in.close();
    return inventory;
  }
  
  public static Inventory loadFromYaml(File file)
    throws IOException, InvalidConfigurationException
  {
    YamlConfiguration yaml = new Utf8YamlConfiguration();
    yaml.load(file);
    
    int inventorySize = yaml.getInt("size", 54);
    Inventory inventory = Bukkit.getServer().createInventory(null, inventorySize);
    
    ConfigurationSection items = yaml.getConfigurationSection("items");
    for (int slot = 0; slot < inventorySize; slot++)
    {
      String slotString = String.valueOf(slot);
      if (items.isItemStack(slotString))
      {
        ItemStack itemStack = items.getItemStack(slotString);
        inventory.setItem(slot, itemStack);
      }
    }
    return inventory;
  }
  
  public static void saveToYaml(Inventory inventory, File file)
    throws IOException
  {
    YamlConfiguration yaml = new Utf8YamlConfiguration();
    
    int inventorySize = inventory.getSize();
    yaml.set("size", Integer.valueOf(inventorySize));
    
    ConfigurationSection items = yaml.createSection("items");
    for (int slot = 0; slot < inventorySize; slot++)
    {
      ItemStack stack = inventory.getItem(slot);
      if (stack != null) {
        items.set(String.valueOf(slot), stack);
      }
    }
    yaml.save(file);
  }
}